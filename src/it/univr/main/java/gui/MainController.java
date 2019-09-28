package gui;


import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import domains.FAWidening;
import grammar.CFGGenerator;
import grammar.ControlFlowGraph;
import grammar.Edge;
import grammar.antlr.MudynLexer;
import grammar.antlr.MudynParser;
import interpreter.AbstractInterpreter;
import interpreter.State;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage primaryStage;
    private File file;
    private static final String CFG_VIEWER_PATH = "cfg_viewer.fxml";

    public MainController(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    @FXML
    private Label titleLabel;

    @FXML
    private Label filePathLabel;

    @FXML
    private Button loadFileButton;

    @FXML
    private Button analyzeFileButton;

    @FXML
    private ComboBox<Integer> wideningValueComboBox;

    @FXML
    void analyze(ActionEvent event) {

        InputStream stream = null;
        MudynLexer lexer = null;
        try {
            stream = new FileInputStream(file);
            lexer = new MudynLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        MudynParser parser = new MudynParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.dimp();
        CFGGenerator mCFCfgGenerator = new CFGGenerator(tree);
        ControlFlowGraph cfg = mCFCfgGenerator.getCFG();

        Scene mainScene = showCfgViewer(cfg, new State());

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(file.getName());
        stage.setScene(mainScene);
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.show();

        primaryStage.close();
    }

    static Scene showCfgViewer(ControlFlowGraph cfg, State initialState) {
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource(CFG_VIEWER_PATH));
        BorderPane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        CfgViewerController mCfgViewerController = loader.getController();
        cfg.getPrinter().setViewController(mCfgViewerController);
        Pane cfgView = cfg.getPrinter().getFxPanel();
        root.setCenter(cfgView);
        Scene mainScene = new Scene(root);

        // Analysis
        new Thread(() -> {
            AbstractInterpreter interpreter = new AbstractInterpreter(cfg, initialState);
            interpreter.fixPoint();
            Platform.runLater(() -> mCfgViewerController.setStates(interpreter.getStates()));
            HashMap<Edge, State> evalEdges = new HashMap<>();
            cfg.getEdges().forEach(edge -> {
                if (edge.getLabel() instanceof MudynParser.EvalContext)
                    evalEdges.put(edge, interpreter.getStates().get(edge.getFrom()));
            });
            Platform.runLater(() -> mCfgViewerController.setEvalEdges(evalEdges));
        }).start();

        // Cfg listener

        new Thread(cfg.getPrinter()::startPump).start();

        return mainScene;
    }

    @FXML
    private void loadFile(ActionEvent event) {
        FileChooser mFileChooser = new FileChooser();
        mFileChooser.setTitle("Select file");
        File mFile = mFileChooser.showOpenDialog(primaryStage);
        if (mFile != null){
            this.file = mFile;
            filePathLabel.setText(mFile.getPath());
            analyzeFileButton.setDisable(false);
        }
        event.consume();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadFileButton.setOnAction(this::loadFile);
        analyzeFileButton.setOnAction(this::analyze);
        wideningValueComboBox.setItems(FAWidening.getValues());
        wideningValueComboBox.getSelectionModel().select(3);
        wideningValueComboBox.setEditable(false);
        wideningValueComboBox.getSelectionModel().selectedItemProperty().addListener(this::wideningValueChanged);
    }

    private void wideningValueChanged(Observable observable, Integer oldValue, Integer newValue) {
        FAWidening.setFaWideningValue(newValue);
    }
}

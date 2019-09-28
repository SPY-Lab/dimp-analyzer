package gui;

import grammar.*;
import grammar.antlr.MudynParser;
import interpreter.*;
import interpreter.Exception.EvaluationException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ResourceBundle;

import domains.AbstractValue;

public class CfgViewerController implements Initializable {
    public Label evalLabel;
    public Separator evalSeparator;
    private HashMap<String, State> states;

    @FXML
    private Label loadingLabel;

    @FXML
    private TilePane nodesTilePane;

    @FXML
    private ListView<Pair<String, AbstractValue>> storeListView;

    @FXML
    private ListView<Pair<AbstractLocation, AbstractValue>> heapListView;


    public void setStates(HashMap<Node, State> states) {
        this.states = new HashMap<>();
        states.forEach((n, s) -> this.states.put(n.getId(), s));
        loadingLabel.setManaged(false);
    }

    public void nodeClicked(String nodeId) {
        if (states == null)
            return;
        State currentState = states.get(nodeId);
        storeListView.getItems().clear();
        heapListView.getItems().clear();
        if (currentState.isNull()){
            storeListView.getItems().add(new Pair<>("NULL STATE", null));
        } else {
            currentState.getStore().forEach((s, v) -> storeListView.getItems().add(new Pair<>(s, v)));
            currentState.getHeap().forEach((al, v) -> heapListView.getItems().add(new Pair<>(al, v)));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storeListView.setCellFactory(l -> new StoreCell());
    }

    public void setCfg(ControlFlowGraph cfg) {
        cfg.getPrinter().setViewController(this);
    }

    public void setEvalEdges(HashMap<Edge, State> edges){
        if (edges == null || edges.isEmpty())
            return;
        evalLabel.setDisable(false);
        evalSeparator.setDisable(false);
        nodesTilePane.setDisable(false);
        ArrayList<Button> buttons = new ArrayList<>();
        edges.forEach((edge, state) -> {
            Button b = new Button();
            b.setText(edge.getFrom().toString());
            b.setOnAction(e -> evalButtonClicked(edge, state));
            b.getStyleClass().add("eval_button");
            buttons.add(b);
        });
        buttons.sort(Comparator.comparingInt(b -> Integer.parseInt(b.getText())));
        nodesTilePane.getChildren().addAll(buttons);
    }

    private void evalButtonClicked(Edge edge, State state) {
        ControlFlowGraph cfg;
        try {
            cfg = AbstractSemantics.getEvalCfg((MudynParser.EvalContext) edge.getLabel(), state);
        } catch (EvaluationException e) {
            printEvalWarning();
            e.printStackTrace();
            return;
        }

        assert cfg != null;
        Stage evalStage = new Stage();
        Scene evalScene = MainController.showCfgViewer(cfg, state);
        evalStage.initModality(Modality.WINDOW_MODAL);
        evalStage.setTitle(edge.getLabelString());
        evalStage.setScene(evalScene);
        evalStage.show();

    }

    private void printEvalWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Eval error");
        alert.setContentText("An evaluation exception has been raised during the eval analysis");
        alert.showAndWait();
    }
}

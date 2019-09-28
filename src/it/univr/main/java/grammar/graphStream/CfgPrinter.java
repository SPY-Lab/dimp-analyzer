package grammar.graphStream;

import grammar.*;
import gui.CfgViewerController;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Screen printer of CFG.
 * Generate a window with the CFG and updates it dynamically.
 * Once fixpoints are computed, click on nodes generate a label to view them.
 */
public class CfgPrinter implements ViewerListener {

    private final ControlFlowGraph cfg;
    private FxViewer mView;
    private boolean loop = true;
    private CfgViewerController mCfgViewerController;

    /**
     * CFG printer constructor.
     *
     * @param cfg cfg to be print
     */
    public CfgPrinter(ControlFlowGraph cfg){
        this.cfg = cfg;
        print();
    }

    /**
     * Stop the printing loop.
     */
    @Override
    public void viewClosed(String s) {
        loop = false;
    }

    /**
     * Manage button pushed event.
     * If node pressed doesn't show its state, then print it, otherwise hide it.
     *
     * @param s state of the node
     */
    @Override
    public void buttonPushed(String s) {
        if (mCfgViewerController != null)
            Platform.runLater(() -> mCfgViewerController.nodeClicked(s));
    }

    @Override
    public void buttonReleased(String s) {

    }

//    @Override
    public void mouseOver(String s) {

    }

//    @Override
    public void mouseLeft(String s) {

    }

    /**
     * Print the control flow graph.
     */
    private void print() {
        Graph mGraph = new SingleGraph("Mudyn");
        System.setProperty("org.graphstream.ui", "javafx");
        mGraph.setAttribute("ui.antialias");
        mGraph.setAttribute("ui.quality");
        mGraph.setAttribute("ui.stylesheet", "url(src/it/univr/main/java/grammar/graphStream/graph_style.css)");
        for (Node n : cfg.getNodes()){
            mGraph.addNode(n.getId());
            mGraph.getNode(n.getId()).setAttribute("ui.label", n.getId());
        }
        AtomicInteger epsilonCounter = new AtomicInteger();
        for (Edge e : cfg.getEdges()) {
            String edgeId = "edge_" + epsilonCounter.getAndIncrement();
            mGraph.addEdge(edgeId, e.getFrom().getId(), e.getTo().getId(), true);
            mGraph.getEdge(edgeId).setAttribute("ui.label", e.getLabelString());
        }
        for (Node finalNode : cfg.getExitNodes())
            mGraph.getNode(finalNode.getId()).setAttribute("ui.class", "exit");
        for (Node entryNode : cfg.getEntryNode())
            mGraph.getNode(entryNode.getId()).setAttribute("ui.class", "entry");

        for (Node n : cfg.getEntryNode())
            mGraph.getNode(n.getId()).setAttribute("xy", 0., 0.);

        mView = new FxViewer(mGraph, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        mView.enableAutoLayout();
    }

    /**
     * Creates a JavaFX Panel containing the graph
     * @return a new JavaFx panel
     */
    public Pane getFxPanel() {
        FxViewPanel cfgPanel = (FxViewPanel) mView.addDefaultView(false, new FxGraphRenderer());
        return new StackPane(cfgPanel);
    }

    public void startPump() {
        ViewerPipe mViewerPipe = mView.newViewerPipe();
        mViewerPipe.addViewerListener(this);
        while (loop) {
            mViewerPipe.pump();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setViewController(CfgViewerController cfgViewerController) {
        mCfgViewerController = cfgViewerController;
    }
}

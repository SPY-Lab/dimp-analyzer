package gui;

import domains.AbstractValue;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

public class StoreCell extends ListCell<Pair<String, AbstractValue>> {

    private HBox cell;
    private Label variable;
    private Label value;

    public StoreCell(){
        init();
    }

    private void init(){
        variable = new Label();
        variable.setPrefWidth(55);
        variable.setMaxWidth(Double.MAX_VALUE);
        value = new Label();
        Separator sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);
        cell = new HBox(variable, sep, value);
    }

    @Override
    protected void updateItem(Pair<String, AbstractValue> pair, boolean empty){
        super.updateItem(pair, empty);

        if (pair == null || empty)
            super.setGraphic(null);
        else {
            init();
            variable.setText(pair.getKey());
            if (pair.getValue() == null) {
                cell = new HBox(variable);
                super.setGraphic(variable);
            }
            else {
                value.setText(pair.getValue().toString());
                super.setGraphic(cell);
            }
        }
    }
}

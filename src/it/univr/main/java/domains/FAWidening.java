package domains;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FAWidening {

    private static int faWideningValue = 4;

    public static int getFaWideningValue() {
        return faWideningValue;
    }

    public static void setFaWideningValue(int faWideningValue) {
        FAWidening.faWideningValue = faWideningValue;
    }

    public static ObservableList<Integer> getValues() {
        ObservableList<Integer> values = FXCollections.observableArrayList();
        values.addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return values;
    }
}

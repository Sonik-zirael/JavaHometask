package shalgueva.sophia;

import java.sql.SQLException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea output;

    @FXML
    private TextField shPrice;

    @FXML
    private Button showBtn;

    @FXML
    private TextField changePrice;

    @FXML
    private Button changeBtn;

    @FXML
    private Slider filterS;

    @FXML
    private Button filterBtn;

    @FXML
    private Label percent;

    private static Double per;

    @FXML
    void initialize() {
        Random rand = new Random();
        filterS.setMin(0);
        filterS.setMax(100);
        filterS.setValue(80);

        filterS.setShowTickLabels(true);
        filterS.setShowTickMarks(true);

        filterS.setBlockIncrement(10);
        filterS.setSnapToTicks(true);
        filterS.valueProperty().addListener((observable, oldValue, newValue) -> {
            percent.setText("" + newValue);
            per = (Double)newValue;
        });
        try {
            DbHandler dbHandler = DbHandler.getInstance();
            dbHandler.deleteEverything();
            for (int i = 0; i < 100; i++) {
                Product t = new Product(i, "ball" + i, rand.nextInt(100));
                dbHandler.addProduct(t);
            }
            dbHandler.getAllProducts();
            showBtn.setOnAction(event -> {
                if (!shPrice.getText().equals("")) {
                    output.setText(dbHandler.getByName(shPrice.getText()));
                }
            });
            changeBtn.setOnAction(event -> {
                if (!changePrice.getText().equals("")) {
                    dbHandler.changePrice(
                            changePrice.getText().split(" ")[0],
                            Double.parseDouble(changePrice.getText().split(" ")[1]));
                }
            });
            filterBtn.setOnAction(event -> dbHandler.filterBase(per, output));
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}

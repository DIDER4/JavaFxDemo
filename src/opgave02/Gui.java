package opgave02;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private int counter = 1;
    Label lblName = new Label("Number:" + counter);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 2 Tæller");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMinHeight(200);
        stage.setMinWidth(300);
        stage.show();
    }
        private void initContent(GridPane pane) {
            // enable this to show grid lines
            pane.setGridLinesVisible(false);

            // set padding of the pane
            pane.setPadding(new Insets(20));
            // set horizontal gap between components
            pane.setHgap(10);
            // set vertical gap between components
            pane.setVgap(10);

            // add a label to the pane (at col=0, row=0)
            pane.add(lblName, 1, 0);


            // add a button to the pane (at col=1, row=1)
            Button btnUpperCase = new Button("+1");
            pane.add(btnUpperCase, 2, 2);
            GridPane.setMargin(btnUpperCase, new Insets(10, 10, 10, 10));
            btnUpperCase.setOnAction(event -> this.tilføj());


            // add a button to the pane (at col=2, row=1)
            Button btnLowerCase = new Button("-1");
            pane.add(btnLowerCase, 0, 2);
            GridPane.setMargin(btnLowerCase, new Insets(10, 10, 10, 10));
            btnLowerCase.setOnAction(event -> this.trækFra());


        }
    private void tilføj() {
        counter++;
        lblName.setText("Number: " + counter);
    }

    private void trækFra() {
        counter--;
        lblName.setText("Number: " + counter);
    }

    }

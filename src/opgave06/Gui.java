package opgave06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    ListView<Car> carsList = new ListView<Car>();

    //Opretbil
    ComboBox<String> maerkeBox = new ComboBox<>();
    private final CheckBox elektroBox = new CheckBox();
    private final TextField modelNavn = new TextField();
    private final TextField prisFelt = new TextField();

    Label lblMaerke = new Label("Mærke");
    Label lblModel = new Label("Model");
    Label lblElektrisk = new Label("Elektrisk");
    Label lblPris = new Label("Pris per dag");


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 6 Biler");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMinHeight(200);
        stage.setMinWidth(300);
        stage.show();

    }

    public void opretBil(Stage stage){
        Stage stage1 = new Stage();
        stage.setTitle("Opgave 6 Biler");
        GridPane pane = new GridPane();
        this.initOpretBil(pane);
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
        pane.setHgap(0);
        // set vertical gap between components
        pane.setVgap(0);

        // add a label to the pane (at col=0, row=0)
        pane.add(carsList, 0,0,2,6);

        // add a button to the pane (at col=1, row=1)
        Button btnConfirm = new Button("Opret Bil");
        pane.add(btnConfirm, 7, 0);
        GridPane.setMargin(btnConfirm, new Insets(10, 10, 10, 0));
        btnConfirm.setOnAction(event -> {
            addNewCar();
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        });

    }
    private void initOpretBil(GridPane pane) {
        // enable this to show grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(0);
        // set vertical gap between components
        pane.setVgap(0);

        // add a label to the pane (at col=0, row=0)
        pane.add(lblMaerke,0,0);
        pane.add(lblModel,0,1);
        pane.add(lblElektrisk,0,2);
        pane.add(lblPris,0,3);


        // add a button to the pane (at col=1, row=1)
        Button btnConfirm = new Button("Opret");
        pane.add(btnConfirm, 1, 4);
        GridPane.setMargin(btnConfirm, new Insets(10, 10, 10, 0));
//        btnConfirm.setOnAction(event ->

    }

    private void addNewCar() {
        String maerke = maerkeBox.getValue();
        String model = modelNavn.getText();
        boolean elektrisk = elektroBox.isSelected();
        int pris = Interger.parseInt(prisFelt.getText());
        Car car = new Car(maerke,model,elektrisk,pris);
        carsList.getItems().add(car);
    }
}

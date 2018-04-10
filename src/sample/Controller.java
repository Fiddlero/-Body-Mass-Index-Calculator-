package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private JFXTextField heightinput;

    @FXML
    private JFXTextField statusOutput;

    @FXML
    private JFXTextField bmiOutput;

    @FXML
    private JFXTextField weightinput;


    @FXML
    void calculate(ActionEvent event) {
    try {
        Double weightValue=Double.parseDouble(weightinput.getText());
        Double heightValue=Double.parseDouble(heightinput.getText());
        Double bmiValue=weightValue/((heightValue/100)*(heightValue/100));
        setResult(bmiValue);
        weightinput.clear();
        heightinput.clear();
    }catch (Exception e){

    }

    }
    void setResult(Double bmiValue){
        bmiOutput.setText(Double.toString(Math.round(bmiValue*100.0)/100.0));
       // bmiOutput.setText(bmiValue.toString());
        if(bmiValue<=18.5){
            statusOutput.setText("Underweight");
        }
        else if(18.6<=bmiValue && bmiValue<=24.9){
            statusOutput.setText("Normal weight");
        }
        else if(25<=bmiValue&& bmiValue<=29.9){
            statusOutput.setText("Overweight");
        }
        else {
            statusOutput.setText("Obesity");
        }

    }
   @FXML
    void close(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }
}

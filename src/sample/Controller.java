package sample;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
/**public class "controller" which contain
 * initialization methods and fields from FXML file.
 * @param heightinput : the variable receives the user's height
 * @param weightinput : the variable receives the user's weight
 * @param bmiOutput : the variable contains the BMI indicator passed on the output
 * @param statusOutput: the variable contains information about the type of body
 */
public class Controller {

    @FXML
    private JFXTextField heightinput;

    @FXML
    private JFXTextField statusOutput;

    @FXML
    private JFXTextField bmiOutput;

    @FXML
    private JFXTextField weightinput;

    /**The method calculate BMI idex and transmit it to the method"setResult"
     */
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
    /**The method prints the BMI idex and checks the type of body
     */
    @FXML
    void setResult(Double bmiValue){
        bmiOutput.setText(Double.toString(Math.round(bmiValue*100.0)/100.0));
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
    /**The method closes the winow program after clicking the mouse
    */
   @FXML
    void close(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }
}

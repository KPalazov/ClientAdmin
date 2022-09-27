/**
* Java2 Project
* Date: 2022-08-13
*/
package customersadmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Kaloyan Palazov
 */

public class FXMLDocumentController implements Initializable 
{
    
    private Label label;
    @FXML
    private Button addCustomerButton;
    @FXML
    private Button displayAllCustomersButton;
    @FXML
    private Button addOrderButton;
    @FXML
    private Button displayAllOrdersButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button saveButton;
    
    private void handleButtonAction(ActionEvent event) 
    {
        // System.out.println("You clicked me!");
        // label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void addCustomerButtonHandler(ActionEvent event) throws Exception 
    {
        Switch.changeToScene (getClass(), event, "CustomerAddFXML.fxml");
    }

    @FXML
    private void displayAllCustomersButtonHandler(ActionEvent event) throws Exception 
    {
        Switch.changeToScene (getClass(), event, "CustomerDisplayAllFXML.fxml");
    }


    @FXML
    private void displayAllOrdersButtonHandler(ActionEvent event) 
    {
        // TODO
    }

    @FXML
    private void exitButtonHandler(ActionEvent event) 
    {
        // CustomerAddFXMLController.saveCustomersToFile ();
        System.exit (0); // Exit app
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) 
    {
        CustomerAddFXMLController.saveCustomersToFile ();
    }
    
}

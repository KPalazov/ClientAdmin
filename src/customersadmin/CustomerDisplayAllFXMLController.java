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
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Kaloyan Palazov
 */
public class CustomerDisplayAllFXMLController implements Initializable 
{

    @FXML
    private TextArea displayTextArea;
    @FXML
    private Button returnToMainMenuButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
        // setText(), getText()
        
        String outStr = "ID       Name                Phone                Email"                + "\n" +
                        "-------  ------------------- -------------------- --------------------" + "\n";
        
        for (Customer c: CustomerAddFXMLController.customersArrayList)
        {
            outStr += c.toString() + "\n";
        }
        
        outStr += "-> " + CustomerAddFXMLController.customersArrayList.size() + 
                  " customers found." + "\n";
        
        displayTextArea.setText (outStr);
        
        displayTextArea.setFont (new Font ("Courier New", 12));
        
        displayTextArea.setEditable (false); // read-only
    }    

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception
    {
        Switch.changeToScene (getClass(), event, "FXMLDocument.fxml");
    }
    
}

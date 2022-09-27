/**
* Java2 Project
* Date: 2022-08-13
*/
package customersadmin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Kaloyan Palazov
 */
public class CustomerAddFXMLController implements Initializable 
{
    public static final String FILE_NAME = "customers.bin";

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button addStudentButton;
    @FXML
    private Button clearAllButton;
    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private Label nameLabel;

    
    static ArrayList<Customer> customersArrayList = new ArrayList<Customer>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        //customersArrayList = new ArrayList<Customer>();
    }    

    @FXML
    private void addCustomerButtonHandler(ActionEvent event) 
    {
        boolean dataValid = true;
        
        String nameStr = nameTextField.getText().trim();
        String phoneStr = phoneTextField.getText().trim();
        String emailStr = emailTextField.getText().trim();

        // If all inputs are valid, create a Customer object
        // and add them to an array list.
        
        try
        {
           Customer c = new Customer (nameStr,
                                     phoneStr,
                                     emailTextField.getText().trim() );

            customersArrayList.add (c);
         
            JOptionPane.showMessageDialog (null, "Success: customer created.");
        }
        catch (Exception err)
        {
            JOptionPane.showMessageDialog (null, err.getMessage() );
        }
    }

    @FXML
    private void clearAllButtonHandler(ActionEvent event) 
    {
        nameTextField.setText ("");
        phoneTextField.setText ("");
        emailTextField.setText ("");        
    }

    @FXML
    private void returnToMainMenuButtonHandler(ActionEvent event) throws Exception 
    {
        Switch.changeToScene (getClass(), event, "FXMLDocument.fxml");
    }

    public static void saveCustomersToFile ()
    {
        try (Formatter outFile = new Formatter (FILE_NAME) )
        {
            for (Customer c : customersArrayList)
            {
                outFile.format (c.toStringWithLineBreak() ); 
            }
        }
        catch (Exception err)
        {
            System.out.println ("ERROR: file could not be saved: '" + FILE_NAME + "'.");
            JOptionPane.showMessageDialog (null, "ERROR: file could not be saved: '" + FILE_NAME + "'.");
        }
    }

    public static void loadCustomersFromFile ()
    {
        try (Scanner inFile = new Scanner (new FileReader (FILE_NAME) ) )
        {
            while (inFile.hasNext() == true)
            {
                Customer c = new Customer (Integer.parseInt (inFile.nextLine()), inFile.nextLine(), 
                                         inFile.nextLine(), inFile.nextLine() );
                customersArrayList.add (c);
         
            }
        }catch (Exception err)
        {
            JOptionPane.showMessageDialog (null, "ERROR: invalid data, file could not be loaded: '" + 
                                           FILE_NAME + "'." + "\n\n" + err.getMessage() );    
        }

    }    
}

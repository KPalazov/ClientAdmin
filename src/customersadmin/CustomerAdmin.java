/**
* Java FX Project
* Date: 2022-08-13
* @author Kaloyan Palazov
* 
*/

package customersadmin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @autor Kaloyan Palazov
 */


public class CustomerAdmin extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        // Load the data from file
        CustomerAddFXMLController.loadCustomersFromFile ();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
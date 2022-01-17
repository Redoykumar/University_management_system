/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import university_management_system.DatabaseConnection;


public class DashboardFXMLController implements Initializable {

    @FXML
    private Text St;
    @FXML
    private Text Tt;
    @FXML
    private Text Ct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DatabaseConnection con = new DatabaseConnection();
            String s = con.Gread();
            String s1 = con.samister();
            Tt.setText(s);
            Ct.setText(s1);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}

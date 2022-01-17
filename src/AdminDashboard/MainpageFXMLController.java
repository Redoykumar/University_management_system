package AdminDashboard;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import university_management_system.DatabaseConnection;
import static university_management_system.FXMLDocumentController.user;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MainpageFXMLController implements Initializable {
    
    @FXML
    private Text St;
    @FXML
    private Text Tt;
    @FXML
    private Text Ct;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            DatabaseConnection con = new DatabaseConnection();
            String s = con.st();
            String s1 = con.tt();
            String s2 = con.samister();
            St.setText(s);
            Tt.setText(s1);
            Ct.setText(s2);

        } catch (SQLException ex) {
            Logger.getLogger(MainpageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

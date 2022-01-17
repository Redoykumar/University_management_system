package university_management_system;

import AdminDashboard.AdminDashboardFXMLController;
import Faculty.FacultyDashboardFXMLController;
import Student.StudentDashboardFXMLController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static university_management_system.University_management_system.main;
import static university_management_system.University_management_system.pointer;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField userF;
    @FXML
    private TextField passwordF;
    @FXML
    private Label info;
    static public String user = "";
    @FXML
    private ImageView g;

    public static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) throws IOException, SQLException {
        user = userF.getText().trim();
        String pass = passwordF.getText().trim();
        if (user.equals("") || pass.equals("")) {
            return;
        }
        Parent root = null;

        DatabaseConnection con = new DatabaseConnection();
        String res = con.Vlogin(user, pass);
        if (res.equals("admin")) {
            root = FXMLLoader.load(getClass().getResource("/AdminDashboard/adminDashboardFXML.fxml"));

        } else if (res.equals("student")) {
            root = FXMLLoader.load(getClass().getResource("/Student/StudentDashboardFXML.fxml"));
            // University_management_system.stage.close();
        } else if (res.equals("faculty")) {
            root = FXMLLoader.load(getClass().getResource("/Faculty/FacultyDashboardFXML.fxml"));
            //  University_management_system.stage.close();

        } else {
            info.setText("Wrong password");
            return;
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        this.stage = stage;
        stage.setScene(scene);

        stage.show();
        System.out.println(pointer);
        System.out.println("u="+University_management_system.stage);
        System.out.println("A="+AdminDashboardFXMLController.stage);
        System.out.println("F="+FacultyDashboardFXMLController.stage);
        System.out.println("Fx="+FXMLDocumentController.stage);
        
        if(pointer.equals("ums"))
        {
            University_management_system.stage.close();
            University_management_system.stage=null;
           
            
        }
        else if(pointer.equals("A"))
        {
              AdminDashboardFXMLController.stage.close();
              AdminDashboardFXMLController.stage=null;
             
        }
         else if(pointer.equals("F"))
        {
             
              FacultyDashboardFXMLController.stage.close();
              FacultyDashboardFXMLController.stage=null;
             
              
        }
         else if(pointer.equals("S"))
        {
             
              StudentDashboardFXMLController.stage.close();
              StudentDashboardFXMLController.stage=null;
             
              
        }
        
      
      

    }

    @FXML
    private void Sineup(ActionEvent event) {
        info.setText("Please contact to the Admin");
    }

}

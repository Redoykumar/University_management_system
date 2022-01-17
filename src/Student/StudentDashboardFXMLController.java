
package Student;

import AdminDashboard.Student;
import AdminDashboard.Teacher;
import Faculty.FacultyDashboardFXMLController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import university_management_system.DatabaseConnection;
import university_management_system.FXMLDocumentController;
import static university_management_system.FXMLDocumentController.user;
import static university_management_system.University_management_system.pointer;


public class StudentDashboardFXMLController implements Initializable {

    @FXML
    private BorderPane Borderpan;
    @FXML
    private Label nameL;
    @FXML
    private VBox main;
    @FXML
    private ImageView ImageV;
    
     public static Stage stage;
    
      Image Male=new Image(getClass().getResourceAsStream("/Image/Graduate-male-icon.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/Graduate-female-icon.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseConnection db = new DatabaseConnection();
        String T_id = user;
        Student T=null;
        try {
            T = db.Search(T_id);
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDashboardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nameL.setText(T.getName());
        if (T.getSex().equals("Male")) {
           
            ImageV.setImage(Male);
            
        } else if (T.getSex().equals("Female")) {
           
           ImageV.setImage(Female);
           
        } else {
             ImageV.setImage(Qmark);
        }
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("DashboardFXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(StudentDashboardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.getChildren().setAll(root);
       
    }    

    @FXML
    private void DoDashboard(MouseEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("DashboardFXML.fxml"));
        main.getChildren().setAll(root);
    }


    @FXML
    private void Dologout(MouseEvent event) throws IOException {
          pointer="S";
        Parent root = FXMLLoader.load(getClass().getResource("/university_management_system/FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
        
        FXMLDocumentController.stage.close();
        FXMLDocumentController.stage=null;
    }

    @FXML
    private void Dcourse(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("CourseFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void DoResult(MouseEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("resultFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void Doupdate(MouseEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("UpdateStudentFXML.fxml"));
        main.getChildren().setAll(root);
    }
    
    
}

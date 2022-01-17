/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Faculty;

import AdminDashboard.AdminDashboardFXMLController;
import AdminDashboard.Student;
import AdminDashboard.Teacher;
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
import university_management_system.University_management_system;
import static university_management_system.University_management_system.pointer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FacultyDashboardFXMLController implements Initializable {

    @FXML
    private BorderPane Borderpan;
    @FXML
    private Label nameL;
    @FXML
    private VBox main;

    /**
     * Initializes the controller class.
     */
     public static Stage stage;
    @FXML
    private ImageView ImageV;
     Image Male=new Image(getClass().getResourceAsStream("/Image/Teachermale.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/teacherFemal.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        DatabaseConnection db = new DatabaseConnection();
        String T_id = user;
        Teacher T=null;
        try {
            T = db.TSearch(T_id);
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
            Logger.getLogger(FacultyDashboardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.getChildren().setAll(root);
       
    }    

    @FXML
    private void DoDashboard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DashboardFXML.fxml"));
        main.getChildren().setAll(root);
    }


    @FXML
    private void DoStudent(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("SearchStudentFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void Dologout(MouseEvent event) throws IOException {
          pointer="F";
       
         Parent root = FXMLLoader.load(getClass().getResource("/university_management_system/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage =new Stage();
        stage.setScene(scene);
         this.stage=stage;
        stage.show();
            FXMLDocumentController.stage.close();
            FXMLDocumentController.stage=null;
    }

    @FXML
    private void DoUpdate(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("UpdateinformationFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void DoGread(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddgradeFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void DoCourse(MouseEvent event) {
    }
    
}

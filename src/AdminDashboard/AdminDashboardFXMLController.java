/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import Faculty.FacultyDashboardFXMLController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import university_management_system.DatabaseConnection;
import university_management_system.DatabaseConnection;
import university_management_system.FXMLDocumentController;
import university_management_system.University_management_system;
import static university_management_system.University_management_system.pointer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminDashboardFXMLController implements Initializable {

    @FXML
    private Label nameL;
    @FXML
    private BorderPane Borderpan;
    @FXML
    public VBox main;

    public static VBox cn = null;

    public static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        cn = main;
        try {
            nameL.setText(FXMLDocumentController.user);
            Parent root = FXMLLoader.load(getClass().getResource("MainpageFXML.fxml"));
            main.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(AdminDashboardFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void DoDashboard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainpageFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void DoTeacher(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainpageTeacherFXML.fxml"));
        main.getChildren().setAll(root);
    }

    @FXML
    private void DoStudent(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainpageStudentFXML.fxml"));
        main.getChildren().setAll(root);

    }

    @FXML
    private void Dologout(MouseEvent event) throws IOException {
         pointer="A";
        Parent root = FXMLLoader.load(getClass().getResource("/university_management_system/FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
        
        FXMLDocumentController.stage.close();
        FXMLDocumentController.stage=null;
      

    }

}

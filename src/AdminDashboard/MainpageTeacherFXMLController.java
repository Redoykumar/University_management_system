/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import static AdminDashboard.AdminDashboardFXMLController.cn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MainpageTeacherFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DoShowTeacher(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ShowAllTeacherFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void DoAddTeacher(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("AddTeacherFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void DoDeletedTeacher(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("DeletedTeacherFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void DoUpdateTeacher(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("UpdateTeacherFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void SearchTeacher(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("SearchTeacherFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void TeacherCourse(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("CourseTeacherFXML.fxml"));
        cn.getChildren().setAll(root);
    }
    
}

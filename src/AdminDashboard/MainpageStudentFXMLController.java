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
public class MainpageStudentFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void DoAllStudent(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("showAlllStudentFXML.fxml"));
        cn.getChildren().setAll(root);

    }

    @FXML
    private void DoAddStudent(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddStudentFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void DeletedStudent(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeletedStudentFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void UpdateStudent(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UpdateStudentFXML.fxml"));
        cn.getChildren().setAll(root);
    }

    @FXML
    private void SearchStudent(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("SearchStudentFXML.fxml"));
        cn.getChildren().setAll(root);
        
    }

    @FXML
    private void DoCourse(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CourseStudentFXML.fxml"));
        cn.getChildren().setAll(root);
    }

}

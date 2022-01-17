/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import static AdminDashboard.ShowAlllStudentFXMLController.list;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import university_management_system.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ShowAllTeacherFXMLController implements Initializable {

    @FXML
    private TableView<Teacher> TableV;
    @FXML
    private TableColumn<Teacher, String> Id;
    @FXML
    private TableColumn<Teacher, String> Name;
    @FXML
    private TableColumn<Teacher, Integer> Age;
    @FXML
    private TableColumn<Teacher, String> Email;
    @FXML
    private TableColumn<Teacher, String> Sex;
    @FXML
    private TableColumn<Teacher, String> Phone;
    @FXML
    private TableColumn<Teacher, String> Subject;
    @FXML
    private TableColumn<Teacher, String> Address;

   
    ObservableList<Teacher> Tlist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         DatabaseConnection db = new DatabaseConnection();
        
        try {
            Tlist=db.getTeacher();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAllTeacherFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         TableV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       // AddstudentController.list.clear();
        Id.setCellValueFactory(new PropertyValueFactory<Teacher, String>("T_id"));
        Name.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("age")); 
        Email.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Email"));
        Sex.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Sex"));
        Phone.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Phone"));
        Address.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Address"));
        Subject.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Subject"));
        TableV.setItems(Tlist);
        
    }    
    
}

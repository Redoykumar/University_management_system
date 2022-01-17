
package AdminDashboard;

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



public class ShowAlllStudentFXMLController implements Initializable {
    
     public static ObservableList<Student> list = FXCollections.observableArrayList();
     
     
    @FXML
    private TableView<Student> TableV;
    @FXML
    private TableColumn<Student, String> Id;
    @FXML
    private TableColumn<Student, String> Name;
    @FXML
    private TableColumn<Student, Integer> Age;
    @FXML
    private TableColumn<Student, String> Email;
    @FXML
    private TableColumn<Student, String> Sex;
    @FXML
    private TableColumn<Student, String> Phone;
    @FXML
    private TableColumn<Student, String> Address;
    @FXML
    private TableColumn<Student, String> T_id;
    @FXML
    private TableColumn<Student, String> Depertment;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseConnection db = new DatabaseConnection();
        try {
            list=db.getStudent();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAlllStudentFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         TableV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       // AddstudentController.list.clear();
        Id.setCellValueFactory(new PropertyValueFactory<Student, String>("S_id"));
        Name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age")); 
        Email.setCellValueFactory(new PropertyValueFactory<Student, String>("Email"));
        Sex.setCellValueFactory(new PropertyValueFactory<Student, String>("Sex"));
        Phone.setCellValueFactory(new PropertyValueFactory<Student, String>("Phone"));
        Address.setCellValueFactory(new PropertyValueFactory<Student, String>("Address"));
        T_id.setCellValueFactory(new PropertyValueFactory<Student, String>("F_id"));
        Depertment.setCellValueFactory(new PropertyValueFactory<Student, String>("Department"));
        TableV.setItems(list);
        
    }    
    
}

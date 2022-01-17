
package Student;

import AdminDashboard.ShowAlllStudentFXMLController;
import static AdminDashboard.ShowAlllStudentFXMLController.list;
import AdminDashboard.Student;
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


public class CourseFXMLController implements Initializable {

    @FXML
    private TableView<Course> TableV;
    @FXML
    private TableColumn<Course, String> Course_ID;
    @FXML
    private TableColumn<Course, String> Course_name;
    @FXML
    private TableColumn<Course, String> Duration;
    @FXML
    private TableColumn<Course, String> Fee;

     public static ObservableList<Course> Course = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseConnection db = new DatabaseConnection();
        
        try {
            Course=db.getcourse();
        } catch (SQLException ex) {
            Logger.getLogger(CourseFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         TableV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
          Course_ID.setCellValueFactory(new PropertyValueFactory<Course, String>("Course_ID"));
          Course_name.setCellValueFactory(new PropertyValueFactory<Course, String>("Course_name"));
          Duration.setCellValueFactory(new PropertyValueFactory<Course, String>("Duration"));
          Fee.setCellValueFactory(new PropertyValueFactory<Course, String>("Fee"));
         TableV.setItems(Course);
       
    }    
    
}

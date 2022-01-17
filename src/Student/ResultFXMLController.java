
package Student;

import AdminDashboard.Student;
import static Student.CourseFXMLController.Course;
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

public class ResultFXMLController implements Initializable {
public static ObservableList<Result> result = FXCollections.observableArrayList();
    @FXML
    private TableView<Result> TableV;
    @FXML
    private TableColumn<Result, String> Major;
    @FXML
    private TableColumn<Result, String> Mark;
    @FXML
    private TableColumn<Result, String> Samister;
    @FXML
    private TableColumn<Result, String> F_ID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          DatabaseConnection db = new DatabaseConnection();
        
        
    try {
        result=db.getResult();
    } catch (SQLException ex) {
        Logger.getLogger(ResultFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        
         TableV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
          Major.setCellValueFactory(new PropertyValueFactory<Result, String>("Major"));
          Mark.setCellValueFactory(new PropertyValueFactory<Result, String>("Mark"));
          Samister.setCellValueFactory(new PropertyValueFactory<Result, String>("Samister"));
          F_ID.setCellValueFactory(new PropertyValueFactory<Result, String>("F_ID"));
          
         TableV.setItems(result);
       
       
        
      
    }    
    
}

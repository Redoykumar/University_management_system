/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import university_management_system.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchTeacherFXMLController implements Initializable {

    @FXML
    private TextField SearchID;
    @FXML
    private Label NameF;
    @FXML
    private Label IdF;
    @FXML
    private Label AgeF;
    @FXML
    private Label EmailF;
    @FXML
    private Label PhoneF;
    @FXML
    private Label SexF;
    @FXML
    private Label SubjectF;
    @FXML
    private Label AddressF;
    @FXML
    private Label info;
    @FXML
    private ImageView ImageV;
    
     String ID=""; 
    
     Image Male=new Image(getClass().getResourceAsStream("/Image/Teachermale.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/teacherFemal.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ImageV.setImage(Qmark); 
    }    

    @FXML
    private void Search(MouseEvent event) throws SQLException {
    
         NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
        PhoneF.setText("");
        SexF.setText("");
        AddressF.setText("");
        SubjectF.setText("");
       
        info.setText("");

        DatabaseConnection db = new DatabaseConnection();
        String T_id = SearchID.getText().trim();
       Teacher t= db.TSearch(T_id);

        NameF.setText(t.getName());
        IdF.setText(t.getT_id());
        AgeF.setText("" + t.getAge());
        EmailF.setText(t.getEmail());
        PhoneF.setText(t.getPhone());
        SexF.setText(t.getSex());
        if (t.getSex().equals("Male")) {
            //Sex="Male";
            ImageV.setImage(Male);
           
        } else if (t.getSex().equals("Female")) {
           // Sex="Female";
           ImageV.setImage(Female);
           ;
        } else {
           
        }
        AddressF.setText(t.getAddress());
        SubjectF.setText(t.getSubject());
        
        ID = T_id;
    }
    
    
}

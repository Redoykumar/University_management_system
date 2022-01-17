/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class DeletedTeacherFXMLController implements Initializable {

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
    private Label info;
    @FXML
    private Label SubjectF;

    String ID = "";
    @FXML
    private Label AddressF;
    
    Image Male=new Image(getClass().getResourceAsStream("/Image/Teachermale.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/teacherFemal.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    @FXML
    private ImageView ImageV;
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

    @FXML
    private void DoDeleted(ActionEvent event) throws SQLException {
        if (ID.equals("")) {
            return;
        }
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
       
        String query1 = "DELETE from login WHERE F_id ='" + ID + "'";
        String query = "DELETE from faculty WHERE F_id ='" + ID + "'";
        st.executeUpdate(query1);
        st.executeUpdate(query);
        System.out.println(st.executeUpdate(query) > 0);
        if (st.executeUpdate(query) > 0) {

            info.setText("Deleted Faild");

        } else {
            info.setText("Deleted Succesfully");
        }
        ID = "";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import university_management_system.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddTeacherFXMLController implements Initializable {

    @FXML
    private TextField NameF;
    @FXML
    private TextField AgeF;
    @FXML
    private TextField PhoneF;
    @FXML
    private TextField EmailF;
    @FXML
    private TextArea AddressF;
    @FXML
    private CheckBox MaleE;
    @FXML
    private CheckBox FemaleE;
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;
    @FXML
    private TextField SubjectF;
    @FXML
    private Label InfoL;
    @FXML
    private Label InfoL1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     String Sex;

    @FXML
    private void MaleC(ActionEvent event) {
        Sex = "Male";
        FemaleE.setSelected(false);
    }

    @FXML
    private void FemaleC(ActionEvent event) {
        Sex = "Female";
        MaleE.setSelected(false);
    }

    @FXML
    private void DoSave(ActionEvent event) throws SQLException {
        
        DatabaseConnection db = new DatabaseConnection();
        String s = db.lastTID();
        String T_id = "";
        int id = Integer.parseInt(s.substring(2, s.length()));
        id++;
        T_id += id;
        T_id = "T-" + T_id;
        
        String name=NameF.getText();
        String age=AgeF.getText();
        String Email=EmailF.getText();
        String Phone=PhoneF.getText();
        String Address=AddressF.getText();
        String Subject=SubjectF.getText();
        String p1=pass1.getText().trim();
        String p2=pass2.getText().trim();
            
          if(name.equals("")||Email.equals("")||age.equals("")||Sex.equals("")||Phone.equals("")||Address.equals("")||SubjectF.equals("")||pass1.equals("")||pass2.equals(""))
          {
            InfoL.setText("Found Empty TextFild");
            return;  
          }
        Teacher t = new Teacher(T_id, name,Integer.parseInt(age), Email, Sex, Phone,Subject, Address);
        if(p1.equals(p2)&&!p1.equals(""))
        {
              Connection con = db.getConnection();
             Statement st = con.createStatement();
              InfoL.setText(db.insertTeacher(t));
          String query1="INSERT INTO login VALUES (NULL, NULL, NULL, '"+T_id+"', '"+p2+"')";
          st.executeUpdate(query1);
           InfoL1.setText("Password change Succesfully");
        }
        else 
        {
            InfoL1.setText("Password can't match");
        }
       
        NameF.clear();
        AgeF.clear();
        PhoneF.clear();
        EmailF.clear();
        AddressF.clear();
       SubjectF.clear();
        MaleE.setSelected(false);
        FemaleE.setSelected(false);
        pass1.clear();
        pass2.clear();
    }

    @FXML
    private void DoReste(ActionEvent event) {
         NameF.clear();
        AgeF.clear();
        PhoneF.clear();
        EmailF.clear();
        AddressF.clear();
       SubjectF.clear();
        MaleE.setSelected(false);
        FemaleE.setSelected(false);
        pass1.clear();
        pass2.clear();
    }

}

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
public class AddStudentFXMLController implements Initializable {

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
    private TextField T_idF;
    @FXML
    private Label InfoL;
    @FXML
    private CheckBox MaleE;
    @FXML
    private CheckBox FemaleE;
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;
    @FXML
    private Label InfoL1;
    @FXML
    private TextField DepartmentF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        String s = db.lastID();
        String S_id = "";
        int id = Integer.parseInt(s.substring(2, s.length()));
        id++;
        S_id += id;
        S_id = "S-" + S_id;  
        String name = NameF.getText().trim();
        String age = AgeF.getText().trim();
        String Email = EmailF.getText().trim();
        String Phone = PhoneF.getText().trim();
        String Address = AddressF.getText().trim();
        String F_id = T_idF.getText().trim();
        String Department = DepartmentF.getText().trim();
        String p1 = pass1.getText().trim();
        String p2 = pass2.getText().trim();

        Connection con1= db.getConnection();
        Statement st1 = con1.createStatement();
       
        String query = "SELECT * from department WHERE D_Name = '"+Department+"';";
         
        ResultSet rs = st1.executeQuery(query);
       String D_ID=null;
        while(rs.next())
        {
            D_ID=rs.getString("D_ID");
        }
        

        if (name.equals("") || Email.equals("") || age.equals("") || Sex.equals("") || Phone.equals("") || Address.equals("") || F_id.equals("") || pass1.equals("") || pass2.equals("") || D_ID.equals("")) {
            InfoL.setText("Found Empty TextFild");
            return;
        }

        Student std = new Student(S_id, name, Integer.parseInt(age), Email, Sex, Phone, Address, F_id,D_ID);
        if (p1.equals(p2) && !p1.equals("")) {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            InfoL.setText(db.insertStudent(std));
            String query1 = "INSERT INTO login VALUES (NULL, NULL, '" + S_id + "', NULL, '" + p2 + "')";
            st.executeUpdate(query1);
            InfoL1.setText("Password change Succesfully");
        } else {
            InfoL1.setText("Password can't match");
        }

        NameF.clear();
        AgeF.clear();
        PhoneF.clear();
        EmailF.clear();
        AddressF.clear();
        T_idF.clear();
        MaleE.setSelected(false);
        FemaleE.setSelected(false);
        pass1.clear();
        pass2.clear();
        DepartmentF.clear();
    }

    @FXML
    private void DoReste(ActionEvent event) {

        NameF.clear();
        AgeF.clear();
        PhoneF.clear();
        EmailF.clear();
        AddressF.clear();
        T_idF.clear();
        InfoL.setText("");
        InfoL1.setText("");
        MaleE.setSelected(false);
        FemaleE.setSelected(false);
        pass1.clear();
        pass2.clear();
        DepartmentF.clear();
    }

}

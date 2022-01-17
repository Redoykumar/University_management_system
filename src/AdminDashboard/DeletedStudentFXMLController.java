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
import javafx.scene.text.Text;
import university_management_system.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DeletedStudentFXMLController implements Initializable {

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
    private Label AddressF;
    @FXML
    private Label TeacherF;
    @FXML
    private Label TeacherNameF;
    @FXML
    private TextField SearchID;
    @FXML
    private Label info;
    String ID = "";
    Image Male = new Image(getClass().getResourceAsStream("/Image/Graduate-male-icon.png"));
    Image Female = new Image(getClass().getResourceAsStream("/Image/Graduate-female-icon.png"));
    Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    @FXML
    private ImageView ImageV;
    String Sex ="";
    @FXML
    private Label Dep;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ImageV.setImage(Qmark);
    }

    @FXML
    private void Search(MouseEvent event) throws SQLException {
        NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
        PhoneF.setText("");
        Dep.setText("");
        SexF.setText("");
        AddressF.setText("");
        TeacherF.setText("");
        TeacherNameF.setText("");
        info.setText("");

        DatabaseConnection db = new DatabaseConnection();
        String S_id = SearchID.getText().trim();
        Student std = db.Search(S_id);

        NameF.setText(std.getName());
        IdF.setText(std.getS_id());
        AgeF.setText("" + std.getAge());
        EmailF.setText(std.getEmail());
        PhoneF.setText(std.getPhone());
        SexF.setText(std.getSex());
        if (std.getSex().equals("Male")) {
          
            ImageV.setImage(Male);
           
        } else if (std.getSex().equals("Female")) {
          
           ImageV.setImage(Female);
           
        } else {
          
        }
        AddressF.setText(std.getAddress());
        TeacherF.setText(std.getF_id());
        Connection con1= db.getConnection();
        Statement st1 = con1.createStatement();
       
        String query1 = "SELECT * from department WHERE D_ID = '"+std.getDepartment()+"';";
         
        ResultSet rs1 = st1.executeQuery(query1);
       String D_ID=null;
        while(rs1.next())
        {
            D_ID=rs1.getString("D_Name");
            
        }
         Dep.setText(D_ID);
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        String query = "select * FROM faculty where f_id='" + std.getF_id() + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            TeacherNameF.setText(rs.getString("Name"));
        }
        ID = S_id;
    }

    @FXML
    private void DoDeleted(ActionEvent event) throws SQLException {
        if (ID.equals("")) {
            return;
        }
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        Statement s1 = con.createStatement();
        String query1 = "DELETE from login WHERE S_id ='" + ID + "'";
        String query = "DELETE from student WHERE S_id ='" + ID + "'";
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

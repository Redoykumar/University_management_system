
package Faculty;

import AdminDashboard.*;
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


public class SearchStudentFXMLController implements Initializable {

    @FXML
    private TextField SearchF;
    @FXML
    private ImageView ImageV;
    @FXML
    private Label NameF;
    @FXML
    private Label IdF;
    @FXML
    private Label AgeF;
    @FXML
    private Label EmailF;
    @FXML
    private Label PhonoF;
    private Label SexF;
    private Label AddressF;
    private Label T_idF;
    private Label T_nameF;
    String Sex="";

     Image Male=new Image(getClass().getResourceAsStream("/Image/Graduate-male-icon.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/Graduate-female-icon.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));

    @FXML
    private Label Dep;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageV.setImage(Qmark);  
    }  

    @FXML
    private void DoSearch(MouseEvent event) throws SQLException {
        
        NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
        SexF.setText("");
        PhonoF.setText("");
        AddressF.setText("");
        T_idF.setText("");
        T_nameF.setText("");
        Dep.setText("");
        
         DatabaseConnection db = new DatabaseConnection();
        String S_id = SearchF.getText().trim();
        Student std = db.Search(S_id);
        NameF.setText(std.getName());
        IdF.setText(std.getS_id());
        AgeF.setText("" + std.getAge());
        EmailF.setText(std.getEmail());
        PhonoF.setText(std.getPhone());
        if (std.getSex().equals("Male")) {
            Sex="Male";
            ImageV.setImage(Male);
           
        } else if (std.getSex().equals("Female")) {
           Sex="Female";
           ImageV.setImage(Female);
           ;
        } else {
           
        }
        SexF.setText(Sex);
        AddressF.setText(std.getAddress());
        T_idF.setText(std.getF_id());
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
        String query = "select * FROM faculty where F_id='"+std.getF_id()+"'";
        ResultSet rs = st.executeQuery(query);
       
        while(rs.next())
        {
            String s_id = rs.getString("Name");
            T_nameF.setText(s_id);
        }
    }

   
    
}

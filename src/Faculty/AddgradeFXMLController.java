/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Faculty;

import AdminDashboard.Student;
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
import static university_management_system.FXMLDocumentController.user;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddgradeFXMLController implements Initializable {

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
   
    @FXML
    private Label Dep;
    @FXML
    private TextField MajorF;
    @FXML
    private TextField SamisterF;
    @FXML
    private TextField MarkF;
    @FXML
    private Label Info;
    @FXML
    private Label EmailF1;
    String Sex ="";
    String id="";
      Image Male=new Image(getClass().getResourceAsStream("/Image/Graduate-male-icon.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/Graduate-female-icon.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DoSearch(MouseEvent event) throws SQLException {
         NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
       
        PhonoF.setText("");
       
       
        Dep.setText("");
        
         DatabaseConnection db = new DatabaseConnection();
        String S_id = SearchF.getText().trim();
        id=S_id;
        Student std = db.Search(S_id);
        NameF.setText(std.getName());
        IdF.setText(std.getS_id());
        AgeF.setText(""+ std.getAge());
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
        
    }

    @FXML
    private void DoAdd(ActionEvent event) throws SQLException {
         DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        Statement stm = con.createStatement();
        String query = "INSERT INTO grade VALUES (NULL, '"+MarkF.getText()+"', '"+Dep.getText()+"', '"+SamisterF.getText()+"', '"+id+"', '"+user+"');";
       
        if (stm.executeUpdate(query) > 0) {
            Info.setText("Add Grade Succesfully");
        } else {
           Info.setText("Faild");
        }
         SearchF.setText("");
        NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
        PhonoF.setText("");
       
        Dep.setText("");
        MajorF.clear();
        SamisterF.clear();
        MarkF.clear();
        Info.setText("");
        EmailF1.setText("");
        
        
    }

    @FXML
    private void DoClear(ActionEvent event) {
        SearchF.setText("");
        NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
        PhonoF.setText("");
       
        Dep.setText("");
        MajorF.clear();
        SamisterF.clear();
        MarkF.clear();
        Info.setText("");
        EmailF1.setText("");
       
        
    }
    
}

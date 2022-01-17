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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import university_management_system.DatabaseConnection;

public class UpdateStudentFXMLController implements Initializable {

    @FXML
    private TextField SearchID;
    @FXML
    private TextField NameF;
    @FXML
    private Label IdL;
    @FXML
    private TextField AgeF;
    @FXML
    private TextField EmailF;
    @FXML
    private TextField PhoneF;
    private TextField SexF;
    @FXML
    private TextField AddressF;
    @FXML
    private TextField TeacherIIDF;
    @FXML
    private TextField Dep;
    @FXML
    private TextField pass1F;
    @FXML
    private TextField pass2F;
    @FXML
    private Label info;
    @FXML
    private CheckBox FemaleE;
    @FXML
    private CheckBox MaleE;

    String ID = "";
    String Sex = "";
    @FXML
    private Label info1;
    @FXML
    private ImageView ImageV;
    Image Male=new Image(getClass().getResourceAsStream("/Image/Graduate-male-icon.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/Graduate-female-icon.png"));
   Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ImageV.setImage(Qmark);
    }

    @FXML
    private void DoSearch(MouseEvent event) throws SQLException {
        NameF.setText("");
        IdL.setText("");
        AgeF.setText("");
        EmailF.setText("");
        PhoneF.setText("");
        AddressF.setText("");
        TeacherIIDF.setText("");
        pass1F.setText("");
        pass2F.setText("");
        info.setText("");
        info1.setText("");
        Dep.setText("");

        DatabaseConnection db = new DatabaseConnection();
        String S_id = SearchID.getText().trim();
        Student std = db.Search(S_id);
        NameF.setText(std.getName());
        IdL.setText(std.getS_id());
        AgeF.setText("" + std.getAge());
        EmailF.setText(std.getEmail());
        PhoneF.setText(std.getPhone());
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
        if (std.getSex().equals("Male")) {
            Sex="Male";
            ImageV.setImage(Male);
            FemaleE.setSelected(true);
            MaleE.setSelected(false);
        } else if (std.getSex().equals("Female")) {
            Sex="Female";
           ImageV.setImage(Female);
            FemaleE.setSelected(false);
            MaleE.setSelected(true);
        } else {
            FemaleE.setSelected(false);
            MaleE.setSelected(false);
        }
        AddressF.setText(std.getAddress());
        TeacherIIDF.setText(std.getF_id());

        ID = S_id;
    }

    @FXML
    private void DoSave(ActionEvent event) throws SQLException {
        String name = NameF.getText();
        String S_id = IdL.getText();
        String Age = AgeF.getText();
        String Email = EmailF.getText();
        String Phone = PhoneF.getText();
        String Depertmnet = Dep.getText();
       
        String Address = AddressF.getText();
        String T_id = TeacherIIDF.getText();
        if (name.equals("") || Email.equals("") || Age.equals("") || Phone.equals("") || Address.equals("") || T_id.equals("")) {
            info.setText("Found Empty TextFild");
            return;
        }
        String p1=pass1F.getText().trim();
        String p2=pass2F.getText().trim();
        
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        Statement st1 = con.createStatement();
        Statement st2 = con.createStatement();
        String query = "UPDATE student SET Name = '" + name + "',Age = '" + Age + "',Email = '" + Email + "',phone = '" + Phone + "',sex = '" + Sex + "',Address = '" + Address + "',F_ID = '" + T_id + "' WHERE  S_id='" + ID + "'";
        st.executeUpdate(query);
        String query2= "UPDATE student set D_ID =(SELECT D_ID FROM department WHERE D_Name = '"+Depertmnet+"') WHERE S_id ='"+ID+"';";
        st2.executeUpdate(query2);
        if(p1.equals(p2)&&!p1.equals(""))
        {
          String query1="UPDATE login SET PASS='"+p2+"' WHERE s_id='"+ID+"'";
          st1.executeUpdate(query1);
           info1.setText("Password change Succesfully");
        }
        else 
        {
            info1.setText("Password can't match");
        }
        
        if (st.executeUpdate(query) > 0) {

            info.setText("Update  Succesfully");

        } else {
            info.setText("Update Faild");
        }

    }

    @FXML
    private void DoReset(ActionEvent event) {

        SearchID.setText("");
        NameF.setText("");
        IdL.setText("");
        AgeF.setText("");
        EmailF.setText("");
        PhoneF.setText("");
        MaleE.setSelected(false);
        FemaleE.setSelected(false);
        AddressF.setText("");
        TeacherIIDF.setText("");
        info.setText("");
        Dep.setText("");
        info1.setText("");
        pass1F.setText("");
        pass2F.setText("");
      
    }

    @FXML
    private void Male(ActionEvent event) {
        Sex="Male";
        ImageV.setImage(Male);
           MaleE.setSelected(false);
    }

    @FXML
    private void Female(ActionEvent event) {
        Sex ="Female";
       ImageV.setImage(Female);
      FemaleE.setSelected(false);
    }

}

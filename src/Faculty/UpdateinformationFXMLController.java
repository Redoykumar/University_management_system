package Faculty;

import AdminDashboard.Teacher;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import university_management_system.DatabaseConnection;
import static university_management_system.FXMLDocumentController.user;

public class UpdateinformationFXMLController implements Initializable {

    private TextField SearchID;
    @FXML
    private ImageView ImageV;
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
    @FXML
    private CheckBox FemaleE;
    @FXML
    private CheckBox MaleE;
    @FXML
    private TextField SubjectF;
    @FXML
    private TextField AddressF;
    @FXML
    private PasswordField pass1F;
    @FXML
    private PasswordField pass2F;
    @FXML
    private Label info1;
    @FXML
    private Label info;

    String ID = "";
    String Sex = "";

    Image Male = new Image(getClass().getResourceAsStream("/Image/Teachermale.png"));
    Image Female = new Image(getClass().getResourceAsStream("/Image/teacherFemal.png"));
    Image Qmark = new Image(getClass().getResourceAsStream("/Image/question-mark-person.png"));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            NameF.setText("");
            IdL.setText("");
            AgeF.setText("");
            EmailF.setText("");
            PhoneF.setText("");
            AddressF.setText("");
            SubjectF.setText("");
            pass1F.setText("");
            pass2F.setText("");
            info.setText("");
            info1.setText("");
            
            DatabaseConnection db = new DatabaseConnection();
            String T_id = user;
            Teacher t = db.TSearch(T_id);
            NameF.setText(t.getName());
            IdL.setText(t.getT_id());
            AgeF.setText("" + t.getAge());
            EmailF.setText(t.getEmail());
            PhoneF.setText(t.getPhone());
            if (t.getSex().equals("Male")) {
                Sex = "Male";
                ImageV.setImage(Male);
                FemaleE.setSelected(true);
                MaleE.setSelected(false);
            } else if (t.getSex().equals("Female")) {
                Sex = "Female";
                ImageV.setImage(Female);
                FemaleE.setSelected(false);
                MaleE.setSelected(true);
            } else {
                FemaleE.setSelected(false);
                MaleE.setSelected(false);
            }
            AddressF.setText(t.getAddress());
            SubjectF.setText(t.getSubject());
            
            ID = T_id;
        } catch (SQLException ex) {
            Logger.getLogger(UpdateinformationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void Male(ActionEvent event) {
        Sex = "Male";
        ImageV.setImage(Male);
        MaleE.setSelected(false);
    }

    @FXML
    private void Female(ActionEvent event) {
        Sex = "Female";
        ImageV.setImage(Female);
        FemaleE.setSelected(false);
    }

    @FXML
    private void DoSave(ActionEvent event) throws SQLException {
        String name = NameF.getText();
        String T_id = IdL.getText();
        String Age = AgeF.getText();
        String Email = EmailF.getText();
        String Phone = PhoneF.getText();

        String Address = AddressF.getText();
        String Subject = SubjectF.getText();
        if (name.equals("") || Email.equals("") || Age.equals("") || Phone.equals("") || Address.equals("") || T_id.equals("") || Subject.equals("")) {
            info.setText("Found Empty TextFild");
            return;
        }
        String p1 = pass1F.getText().trim();
        String p2 = pass2F.getText().trim();

        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        Statement st1 = con.createStatement();
        String query = "UPDATE Faculty SET Name = '" + name + "',Age = '" + Age + "',Email = '" + Email + "',phone = '" + Phone + "',sex = '" + Sex + "',Address = '" + Address + "',Subject = '" + Subject + "' WHERE  F_id='" + ID + "'";
        st.executeUpdate(query);
        if (p1.equals(p2) && !p1.equals("")) {
            String query1 = "UPDATE login SET PASS='" + p2 + "' WHERE F_id='" + ID + "'";
            st1.executeUpdate(query1);
            info1.setText("Password change Succesfully");
        } else {
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
        SubjectF.setText("");
        info.setText("");
        info1.setText("");
        pass1F.setText("");
        pass2F.setText("");
    }

}

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
public class ShowDetailsFXMLController implements Initializable {

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
    private Label SexF;
    @FXML
    private Label AddressF;
    @FXML
    private Label T_idF;
    @FXML
    private Label T_nameF;

    /**
     * Initializes the controller class.
     */
    Image Male=new Image(getClass().getResourceAsStream("/Image/Graduate-male-icon.png"));
   Image Female=new Image(getClass().getResourceAsStream("/Image/Graduate-female-icon.png"));
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageV.setImage(Male);  
    }    

    @FXML
    private void DoSearch(MouseEvent event) throws SQLException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        NameF.setText("");
        IdF.setText("");
        AgeF.setText("");
        EmailF.setText("");
        SexF.setText("");
        PhonoF.setText("");
        AddressF.setText("");
        T_idF.setText("");
        T_nameF.setText("");
        
         DatabaseConnection db = new DatabaseConnection();
        String S_id = SearchF.getText().trim();
        Student std = db.Search(S_id);
        NameF.setText(std.getName());
        IdF.setText(std.getS_id());
        AgeF.setText("" + std.getAge());
        EmailF.setText(std.getEmail());
        PhonoF.setText(std.getPhone());
        if (std.getSex().equals("Male")) {
            //Sex="Male";
            ImageV.setImage(Male);
           
        } else if (std.getSex().equals("Female")) {
           // Sex="Female";
           ImageV.setImage(Female);
           ;
        } else {
           
        }
        AddressF.setText(std.getAddress());
        T_idF.setText(std.getF_id());
        
    }
    
}

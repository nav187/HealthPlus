/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package healthPlus;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import healthPlus.DbConn;
import healthPlus.DbConn;

/**
 * FXML Controller class
 *
 * @author Anju
 */
public class PatientAddController implements Initializable {
    @FXML
    private TextField add_email;
    @FXML
    private TextField add_address;
    @FXML
    private TextField add_postcode;
    @FXML
    private TextField add_state;
    @FXML
    private TextField add_city;
    @FXML
    private TextField add_country;
    @FXML
    private TextField add_phone;
    @FXML
    private RadioButton add_male;
    @FXML
    private RadioButton add_female;
    @FXML
    private TextField add_last;
    @FXML
    private TextField add_first;
    @FXML
    private TextField add_emergency_relationship;
    @FXML
    private TextField add_emergency_phone;
    @FXML
    private TextField add_emergency_last;
    @FXML
    private TextField add_emergency_first;
    @FXML
    private TextField add_practice_address;
    @FXML
    private TextField add_referral_doctor;
    @FXML
    private ChoiceBox<?> add_referral_practice;
    @FXML
    private Button add_new_practice;
    @FXML
    private TextField add_weight;
    @FXML
    private TextField add_height;
    @FXML
    private TextField add_allergy;
    @FXML
    private TextField add_reaction;
    @FXML
    private TextField add_treatment;
    @FXML
    private RadioButton add_severity_high;
    @FXML
    private RadioButton add_severity_med;
    @FXML
    private RadioButton add_severity_low;
    @FXML
    private TextArea add_family_medicalhistory;
    @FXML
    private TextArea add_medicalhistory;
    @FXML
    private TextField add_covertype;
    @FXML
    private TextField add_healthfund;
    @FXML
    private Button add_save;
    @FXML
    private Button add_cancel;
    @FXML
    private TextField add_practice_state;
    @FXML
    private TextField add_practice_postcode;
    @FXML
    private RadioButton add_severity_low1;
    @FXML
    private RadioButton add_severity_med1;
    @FXML
    private RadioButton add_severity_high1;
    @FXML
    private TextField add_treatment1;
    @FXML
    private TextField add_reaction1;
    @FXML
    private TextField add_allergy1;
    @FXML
    private RadioButton add_severity_low2;
    @FXML
    private RadioButton add_severity_med2;
    @FXML
    private RadioButton add_severity_high2;
    @FXML
    private TextField add_treatment2;
    @FXML
    private TextField add_reaction2;
    @FXML
    private TextField add_allergy2;
    
    private Connection conn;
    
    private PreparedStatement prepStatement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    //add_first.getText(), Integer.parseInt(add_height.getText()), 
    @FXML
    private void onAddItem(ActionEvent aE) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        conn = DbConn.connect();
        
        PatientQueries patientQueries = new PatientQueries();
        patientQueries.insertPatient(new Patient(add_first.getText(), add_last.getText(), "female", add_address.getText(), add_city.getText(), add_state.getText(), add_postcode.getText(), add_email.getText(), (add_phone.getText())));

    }
    
    private void clearForm() {
        // clear all input fields
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import healthPlus.DbConn;

/**
 * FXML Controller class
 *
 * @author Navneet
 */
public class PatientSearchController implements Initializable {

    @FXML
    private TextField search_first;
    @FXML
    private TextField search_last;
    @FXML
    private RadioButton search_gender;
    @FXML
    private RadioButton search_male;
    @FXML
    private TextField search_healthcover;
    @FXML
    private ChoiceBox<?> search_diagnosis;
    @FXML
    private Button search_button;
    @FXML
    private TableView search_results;

    @FXML
    private TableColumn PatientID;
    @FXML
    private TableColumn FirstName;
    @FXML
    private TableColumn LastName;
    @FXML
    private TableColumn DOB;

    @FXML

    private Connection conn;

    ObservableList<ObservableList> table;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }

    @FXML
    private void handleButton(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            conn = DbConn.connect();
            String sql = "SELECT patient_id, first_name, last_name, date_of_birth FROM PR_PATIENT where first_name LIKE '%" + search_first.getText() + "%'";
            //"SELECT patient_id, first_name, last_name, date_of_birth FROM PR_PATIENT where first_name LIKE '%"+search_first.getText()+"%'";

            ResultSet rs = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            ObservableList<Object> data = FXCollections.observableArrayList();
            
            
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
               
                search_results.getColumns().addAll(col); 
            }
            
            while (rs.next()) {
                

                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    
                    row.add(rs.getString(i));
                }
                System.out.println(row); 
                data.add(row);
                //search_results.setItems(row);
                
            }
            search_results.setItems(data);
            //search_results.setItems(table);

            //ObservableList<Patient> data = search_results.getItems();
            //data.add(new Patient (FirstName.getText(), LastName.getText(), DOB.getText()));
            //FirstName.setText("");
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

    }

}

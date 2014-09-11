/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package healthPlus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anju
 */
public class PatientQueries extends DbConn {
    
    PreparedStatement insertPatient = null;
    PreparedStatement getAllPatients = null;
    ResultSet rs = null;
    
    
    /**
     * Inserts values from user entry into tables in database
     *
     * @param toInsert Employee type
     * @return row number as an integer
     */
    public void insertPatient(Patient toInsert) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        connect();
        try {
            
            insertPatient = connection.prepareStatement ("INSERT into PR_PATIENT (patient_id, first_name, last_name, gender, address, city, state, post_code, email, phone_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
     
            ResultSet rs = insertPatient.getGeneratedKeys();
            rs.next();
            int returnValue = rs.getInt(1);
            insertPatient.setInt(1, returnValue);
            insertPatient.setString(2, toInsert.getFirstName());
            insertPatient.setString(3, toInsert.getLastName());
            insertPatient.setString(4, toInsert.getGender());
            insertPatient.setString(5, toInsert.getAddress());
            insertPatient.setString(6, toInsert.getCity());
            insertPatient.setString(7, toInsert.getState());
            insertPatient.setString(8, toInsert.getPostCode());
            insertPatient.setString(9, toInsert.getEmail());
            insertPatient.setString(10, toInsert.getContactNumber());
            insertPatient.executeUpdate();
              
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        
    }
    
    
}

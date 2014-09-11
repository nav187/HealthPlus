package healthPlus;

import java.io.Serializable;
import java.util.*;

public class Patient implements Serializable{

    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String address_city;
    private String address_state;
    private String address_postcode;
    private String contactNumber;
    //private Date birthday;
    //private Date dateJoined;
    private String email;
    private String medicareNumber;
    private String allergies;
    private String height;
    private String weight;
    //private Appointment appointment;
    //private MedicalRecord medicalRecord;
    
    
    public Patient(){
        
    }
    
    
    public Patient(String firstName, String lastName, String gender, String address, String address_city, String address_state, String address_postcode, String contactNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_postcode = address_postcode;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address, String address_city, String address_state, String address_postcode) {
        this.address = address;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_postcode = address_postcode;
    }

    
    public String getAddress() {
        return (address + ", " + address_city + ", " + address_state + ", " + address_postcode);
    }
    
    public String getCity() {
        return address_city;
    }
    
    public String getState() {
        return address_state;
    }
    
    
    public String getPostCode() {
        return address_postcode;
    }
    

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getEmail () {
        return email;
    }

    public void setMedicareNumber(String medicareNumber) {
        this.medicareNumber = medicareNumber;
    }

    public String medicareNumber() {
        return medicareNumber;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    /**public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }*/

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
    
    

}

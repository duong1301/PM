/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author LA
 */
public class Employee {
    String id;
    String name;
    String phoneNumber;
    String parkingLotID;

    public Employee(String id, String name, String phoneNumber, String areaID) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.parkingLotID = areaID;
    }

    public Employee() {
    }
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    

    @Override
    public String toString() {
        
        return this.id + "|"+ this.name + "|" + this.phoneNumber + "|" + this.parkingLotID;
    }
    
    
    
    
    
}

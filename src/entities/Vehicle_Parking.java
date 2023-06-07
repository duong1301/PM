/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author LA
 */
public class Vehicle_Parking {
    String parkingLotID;
    String ticket;
    String licensePlate;
    Vehicle type;
    String timeIn;
    String timeOut;
    boolean priority; 

    public Vehicle_Parking(String parkingLotID, String ticket, String licensePlate, Vehicle type, String timeIn, String timeOut, boolean priority) {
        this.parkingLotID = parkingLotID;
        this.ticket = ticket;
        this.licensePlate = licensePlate;
        this.type = type;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.priority = priority;
    }

    public Vehicle_Parking() {
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public String getTicket() {
        return ticket;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Vehicle getType() {
        return type;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setType(Vehicle type) {
        this.type = type;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        
        return (
                ""
                +this.parkingLotID +"|"
                +this.ticket +"|"
                +this.licensePlate +"|"
                +this.type +"|"
                +this.timeIn +"|"
                +this.timeOut +"|"
                +(this.isPriority()? "1":"0")
        );
    }
    
    
    
    
}

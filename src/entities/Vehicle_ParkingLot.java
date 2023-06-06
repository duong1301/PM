/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author LA
 */
public class Vehicle_ParkingLot {
    Ticket ticket;
    String licensePlate;
    Vehicle type;
    String timeIn;
    String timeOut;
    String parkingFee;
    boolean isPriority;

    public Vehicle_ParkingLot(Ticket ticket, String licensePlate, Vehicle type, String timeIn, String timeOut, String parkingFee, boolean isPriority) {
        this.ticket = ticket;
        this.licensePlate = licensePlate;
        this.type = type;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.parkingFee = parkingFee;
        this.isPriority = isPriority;
    }

    public Ticket getTicket() {
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

    public String getParkingFee() {
        return parkingFee;
    }

    public boolean isIsPriority() {
        return isPriority;
    }

    public void setTicket(Ticket ticket) {
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

    public void setParkingFee(String parkingFee) {
        this.parkingFee = parkingFee;
    }

    public void setIsPriority(boolean isPriority) {
        this.isPriority = isPriority;
    }

    @Override
    public String toString() {
        return (
                ""
                +this.ticket.toString()+"|"
                +this.licensePlate+"|"
                +this.type+"|"
                +this.timeIn +"|"
                +this.timeOut+"|"
                +this.parkingFee
        
                
        );
    }
    
    
    
}

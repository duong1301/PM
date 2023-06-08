/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author LA
 */
public class VehicleLoger extends Vehicle_Parking{
    int parkingFee;

    public VehicleLoger(int parkingFee, String parkingLotID, String ticket, String licensePlate, Vehicle type, String timeIn, String timeOut, boolean priority) {
        super(parkingLotID, ticket, licensePlate, type, timeIn, timeOut, priority);
        this.parkingFee = parkingFee;
    }
    
    public VehicleLoger(Vehicle_Parking p, int parkingFee){
        super(p.parkingLotID, p.ticket, p.licensePlate, p.type, p.timeIn, p.timeOut, p.priority);
        this.parkingFee = parkingFee;
    }

    public VehicleLoger(int parkingFee) {
        this.parkingFee = parkingFee;
    }

    public int getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(int parkingFee) {
        this.parkingFee = parkingFee;
    }

    @Override
    public String toString() {
        return super.toString() + "|"+ this.parkingFee;
    }
    
    
    
}

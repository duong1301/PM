/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default
 * .txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package entities;

/**
 * @author LA
 */
public class LoggedVehicle extends Vehicle {
	int parkingFee;

	public LoggedVehicle(int parkingFee, String parkingLotID, String ticket,
			String licensePlate, VehicleType type, String timeIn,
			String timeOut, boolean isPrioritised) {
		super(parkingLotID,
		      ticket,
		      licensePlate,
		      type,
		      timeIn,
		      timeOut,
		      isPrioritised
		);
		this.parkingFee = parkingFee;
	}

	public LoggedVehicle(Vehicle p, int parkingFee) {
		super(p.parkingLotID,
		      p.ticket,
		      p.licensePlate,
		      p.type,
		      p.timeIn,
		      p.timeOut,
		      p.isPrioritised
		);
		this.parkingFee = parkingFee;
	}

	public int getParkingFee() {
		return parkingFee;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + this.parkingFee;
	}
}

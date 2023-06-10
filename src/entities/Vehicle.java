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
public class Vehicle {
	String parkingLotID;
	String ticket;
	String licensePlate;
	VehicleType type;
	String timeIn;
	String timeOut;
	boolean isPrioritised;

	public Vehicle(String parkingLotID, String ticket,
			String licensePlate, VehicleType type, String timeIn,
			String timeOut,
			boolean isPrioritised) {
		this.parkingLotID = parkingLotID;
		this.ticket = ticket;
		this.licensePlate = licensePlate;
		this.type = type;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.isPrioritised = isPrioritised;
	}

	public String getParkingLotID() {
		return parkingLotID;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public String getTimeIn() {
		return timeIn;
	}


	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public boolean isPrioritised() {
		return isPrioritised;
	}

	@Override
	public String toString() {
		return this.parkingLotID + "|"
				+ this.ticket + "|"
				+ this.licensePlate + "|"
				+ this.type + "|"
				+ this.timeIn + "|"
				+ this.timeOut + "|"
				+ (this.isPrioritised() ? "1" : "0");
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default
 * .txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package dataAccess;

import entities.Vehicle;
import entities.VehicleType;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author LA
 */
public class VehicleDataAccess {
	final static String FILE_PATH = "./src/data/vehicle_in.txt";
	private final static File FILE = new File(FILE_PATH);

	public static Map<String, Vehicle> getVehicles() throws Exception {
		FileReader fr = new FileReader(FILE);
		BufferedReader br = new BufferedReader(fr);
		Map<String, Vehicle> vehicles = new TreeMap<>();
		String line;

		while ((line = br.readLine()) != null) {
			String[] vehicleInfo = line.split("\\|");
			String priority = vehicleInfo[6];
			String ticketNumber = vehicleInfo[1];
			Vehicle vehicle = new Vehicle(
					vehicleInfo[0],
					ticketNumber,
					vehicleInfo[2],
					VehicleType.valueOf(vehicleInfo[3]),
					vehicleInfo[4],
					vehicleInfo[5],
					priority.equals("1")
			);

			vehicles.put(ticketNumber, vehicle);
		}

		br.close();
		fr.close();
		return vehicles;
	}

	public static Map<String, Vehicle> getVehicleByParkingID(String id)
			throws Exception {
		return getVehicles().values()
		                    .stream()
		                    .filter(vehicle -> vehicle.getParkingLotID()
		                                              .equals(id))
		                    .collect(Collectors.toMap(Vehicle::getTicket,
		                                              Function.identity()
		                             )
		                    );
	}

	public static void addVehicle(Vehicle v) throws IOException {
		FileWriter fw = new FileWriter(FILE, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(v.toString());
		bw.newLine();

		bw.close();
		fw.close();

	}

	public static boolean removeVehicle(String ticket, String parkingLotID)
			throws Exception {
		Map<String, Vehicle> vehicles = getVehicles();

		FileWriter fw = new FileWriter(FILE);
		BufferedWriter bw = new BufferedWriter(fw);

		boolean hasThisVehicle = vehicles.values().removeIf(
				vehicle -> vehicle.getParkingLotID().equals(parkingLotID));

		if (!hasThisVehicle) return false;

		for (Vehicle val : vehicles.values()) {
			bw.write(val.toString());
			bw.newLine();
			System.out.println(val);
		}

		bw.close();
		fw.close();
		return true;
	}
}

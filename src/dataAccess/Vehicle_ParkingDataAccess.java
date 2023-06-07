/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import entities.Vehicle;
import java.util.List;
import entities.Vehicle_Parking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;



/**
 *
 * @author LA
 */
public class Vehicle_ParkingDataAccess {
    
    final static String FILE_PATH = "./src/data/vehicle_in.txt";
    final static File FILE = new File(FILE_PATH);
    
    public static Map<String,Vehicle_Parking> getVehicles() throws Exception, IOException{   
       
        FileReader fr = new FileReader(FILE);
        BufferedReader br = new BufferedReader(fr);
        Map<String,Vehicle_Parking> vehicles = new TreeMap<>();
        String line = br.readLine();
        while(true){
            if(line == null){
                break;
            }
            
            String[] vehicleInfor = line.split("\\|");
            String type = vehicleInfor[3];
            Vehicle typeVehicle;
            switch (type) {
                case "CAR":
                    typeVehicle = Vehicle.CAR  ;  
                    break;
                case "MOTORBIKE":
                    typeVehicle = Vehicle.MOTORBIKE;
                    break;
                case "BIKECYCLE":
                    typeVehicle = Vehicle.BIKECYCLE;
                    break;
                default:
                    throw new AssertionError();
            }
            
            String priority = vehicleInfor[6];
            boolean isPriority;
            isPriority = "1".equals(priority);
            
            Vehicle_Parking v = new Vehicle_Parking(
                    vehicleInfor[0]
                    , vehicleInfor[1]
                    , vehicleInfor[2]
                    , typeVehicle
                    , vehicleInfor[4]
                    , vehicleInfor[5]
                    , isPriority);
            String tiketNum = vehicleInfor[1];
            vehicles.put(tiketNum, v);
            line = br.readLine();            
        }                
        br.close();
        fr.close();
        return vehicles;
    }
    
    public static Map<String, Vehicle_Parking> getVehicleByParkingID(String id) throws Exception{
        Map<String,Vehicle_Parking> VehicleParkings = getVehicles();
        Map<String,Vehicle_Parking> result = new TreeMap<>();
        for (Map.Entry<String, Vehicle_Parking> entry : VehicleParkings.entrySet()) {
            Object key = entry.getKey();
            Vehicle_Parking val = entry.getValue();
            if(val.getParkingLotID() == null ? id == null : val.getParkingLotID().equals(id)){
                result.put(val.getTicket(), val);
            }
        }
        
        return result;
    
    }
    
    public static void addVehicle(Vehicle_Parking v) throws IOException{
        FileWriter fw = new FileWriter(FILE, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(v.toString());
        bw.newLine();
        
        bw.close();
        fw.close();
        
        
    }
    
    public static void removeVehicle(String ticket) throws IOException, Exception{
        Map<String, Vehicle_Parking> vehicles = getVehicles();

        FileWriter fw = new FileWriter(FILE);
        BufferedWriter bw = new BufferedWriter(fw);
        
        vehicles.remove(ticket);
        
        for (Map.Entry<String, Vehicle_Parking> entry : vehicles.entrySet()) {
            Object key = entry.getKey();
            Vehicle_Parking val = entry.getValue();
            bw.write(val.toString());
            bw.newLine();
                System.out.println(val.toString());
        }
        
        bw.close();
        fw.close();
    }
}

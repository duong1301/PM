/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import entities.ParkingLot;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author LA
 */
public class ParkingLotDataAccess {
    
    public static Map<String, ParkingLot> getParkingLots() throws FileNotFoundException, IOException{
        
        File file = new File("./src/data/parkingLot.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        TreeMap<String, ParkingLot> parkingLots = new TreeMap<>();
        String line = br.readLine();
        
        while(true){
            if(line == null){
                break;
            }
            String [] parkingLotInfor = line.split("\\|");
            ParkingLot p = new ParkingLot(parkingLotInfor[0], parkingLotInfor[1]);
            parkingLots.put(parkingLotInfor[0], p);
            line = br.readLine();
        }
             
        br.close();
        fr.close();
        return parkingLots;
        
    }
    
    public static ParkingLot getParkingLot(String id) throws IOException{
        Map<String, ParkingLot> parkingLots = getParkingLots();
        ParkingLot p = parkingLots.get(id);
        return p;
    }
    
    public static void addParkingLot(ParkingLot p) throws FileNotFoundException, IOException{
        File file = new File("./src/data/parkingLot.txt");
        System.out.println(file.exists());
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(p.toString());
        bw.newLine();
        
        
        bw.close();
        fw.close();        
        
    }
    
    public static void editParkingLot(String id, ParkingLot p) throws IOException{
        File file = new File("./src/data/parkingLot.txt");
     
        Map<String, ParkingLot> parkingLots = getParkingLots();
        
        parkingLots.replace(id, p);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (Map.Entry<String, ParkingLot> entry : parkingLots.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            bw.write(val.toString());
            bw.newLine();
            
        }
        
        bw.close();
        fw.close();
    }
    public static void deleteParkingLot(String id) throws IOException{
        File file = new File("./src/data/parkingLot.txt");
        Map<String, ParkingLot> parkingLots = getParkingLots();
        parkingLots.remove(id);
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (Map.Entry<String, ParkingLot> entry : parkingLots.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            bw.write(val.toString());
            bw.newLine();
        }
        
        bw.close();
        fw.close();
        
    }
}

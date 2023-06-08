/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;


import entities.Vehicle;
import entities.VehicleLoger;
import entities.Vehicle_Parking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LA
 */
public class LogDataAccess {
    
    static final String PATH = "./src/data/log/log";
    
    public static void add(VehicleLoger v) throws IOException{
        
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        File file = new File(PATH + date +".txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(LogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(v.toString());
        bw.newLine();
        
        bw.close();
        fw.close();
        
        System.out.println(file.exists());
        System.out.println(file);
        
    }
    
    public static List<VehicleLoger> getLogs(String log) throws FileNotFoundException, IOException{
        String logPath = PATH + log + ".txt";
        
        List<VehicleLoger> logs = new ArrayList<>();
        File file = new File(logPath);
        if(file.exists()){
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            
            String parkingID;
            String ticket;
            String licensePlate;
            String type;
            String timeIn;
            String timeOut;
            String priority;
            String parkingFee;
            
            while(true){
                if(line == null){
                    break;
                }
                String [] logsInfor = line.split("\\|");
//                System.out.println(logsInfor.);
                parkingID = logsInfor[0];
                ticket = logsInfor[1];
                licensePlate= logsInfor[2];
                type= logsInfor[3];
                Vehicle vehicleType;
                timeIn= logsInfor[4];
                timeOut= logsInfor[5];
                priority= logsInfor[6];
                parkingFee=logsInfor[7];
                
                switch (type) {
                    case "MOTORBIKE":
                        vehicleType = Vehicle.MOTORBIKE;
                        break;
                    case "BIKECYCLE":
                        vehicleType = Vehicle.BIKECYCLE;
                        break;
                    case "CAR":
                        vehicleType = Vehicle.CAR;
                        break;    
                    default:
                        throw new AssertionError();
                }
                
                
                int parkingFeeInt = Integer.parseInt(parkingFee);
                VehicleLoger v = new VehicleLoger(parkingFeeInt, parkingID, ticket, licensePlate, vehicleType, timeIn, timeOut, priority == "1");
                System.out.println(v.toString());
                logs.add(v);
                line = br.readLine();
            }
            
            
            
            
        }
            
            
        return logs;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("loger");
            List<VehicleLoger> logs = getLogs("20230608");
            for (VehicleLoger log : logs) {
                System.out.println(log.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(LogDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

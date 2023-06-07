/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;


import entities.Vehicle_Parking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LA
 */
public class LogDataAccess {
    
    static final String PATH = "./src/data/log/log";
    
    public static void add(Vehicle_Parking v) throws IOException{
        
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
    
    
    
}

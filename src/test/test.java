/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;


import entities.Price;
import entities.Ticket;
import entities.Vehicle;
import entities.Vehicle_Parking;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author LA
 */
public class test {

    public static void main(String[] args) throws IOException, Exception {
        
        LocalDate d = LocalDate.now();
        LocalTime t = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();
//        System.out.println(d.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd - hh:mm:ss")));
        
        
        
    }

}

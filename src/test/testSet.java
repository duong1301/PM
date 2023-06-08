/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 *
 * @author LA
 */
public class testSet {
    
    public static void getDateRange(LocalDate start, LocalDate end){
        if(start.isAfter(end)){
            return;
        }
        System.out.println(start.isBefore(end));

        Stream<LocalDate> s = start.datesUntil(end);
        s.forEach(action->{
            System.out.println(
                    action.format(DateTimeFormatter.ISO_DATE));});
    }
    
    public static void main(String[] args) {
        getDateRange(LocalDate.MIN, LocalDate.MAX);
    }
}

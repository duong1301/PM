/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author LA
 */
public class test {

    public static void main(String[] args) throws  Exception {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd - hh:mm:ss")));
    }

}

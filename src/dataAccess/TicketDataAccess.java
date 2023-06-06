/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import entities.Ticket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author LA
 */
public class TicketDataAccess {
    private static final String TICKET_PATH = "./src/data/ticket.txt";
    
    private static final File FILE = new File(TICKET_PATH);
    
    public static Set<Ticket> getTickets() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(FILE);
        BufferedReader br = new BufferedReader(fr);
        Set<Ticket> tickets = new TreeSet<>();
       
        String line = br.readLine();
        
        while(true){
            if(line == null){
                break;
            }
            tickets.add(new Ticket(line));
            line = br.readLine();
            
            
        }
        
        return tickets;
        
    }
    
    public static void deleteTicket(String ticketNum) throws IOException{
        Set<Ticket> tickets = getTickets();
        if(tickets.contains(new Ticket(ticketNum))){
            System.out.println("delete");
            FileWriter fr = new FileWriter(FILE);
            BufferedWriter br = new BufferedWriter(fr);
            tickets.remove(new Ticket(ticketNum));
            
            for (Ticket ticket : tickets) {
                br.write(ticket.toString());
                br.newLine();
            }
            
            br.close();
            fr.close();
        }
    }
    
    public static void addTicket(Ticket t) throws IOException{
        FileWriter fr = new FileWriter(FILE, true);
        BufferedWriter br = new BufferedWriter(fr);
        
        br.write(t.toString());
        br.newLine();
        
        br.close();
        fr.close();
        
    }
    
}

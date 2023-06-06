/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Ticket;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author LA
 */
public class test {

    public static void main(String[] args) throws IOException {
        Set<Ticket> tickets = dataAccess.TicketDataAccess.getTickets();
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getTicketNum());
            
        }
        dataAccess.TicketDataAccess.deleteTicket("00003");
    }

}

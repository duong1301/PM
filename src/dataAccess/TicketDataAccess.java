/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default
 * .txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package dataAccess;

import entities.Ticket;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author LA
 */
public class TicketDataAccess {
	private static final String TICKET_PATH = "./src/data/ticket.txt";

	private static final File FILE = new File(TICKET_PATH);

	public static Set<Ticket> getTickets() throws IOException {
		FileReader fr = new FileReader(FILE);
		BufferedReader br = new BufferedReader(fr);
		Set<Ticket> tickets = br.lines()
		                        .map(Ticket::new)
		                        .collect(Collectors.toSet());

		br.close();
		fr.close();
		return tickets;

	}

	public static void deleteTicket(String ticketNum) throws IOException {
		Set<Ticket> tickets = getTickets();
		if (tickets.contains(new Ticket(ticketNum))) {
			System.out.println("delete");
			FileWriter fw = new FileWriter(FILE);
			BufferedWriter bw = new BufferedWriter(fw);
			tickets.remove(new Ticket(ticketNum));

			for (Ticket ticket : tickets) {
				bw.write(ticket.toString());
				bw.newLine();
			}

			bw.close();
			fw.close();
		}
	}

	public static void addTicket(Ticket t) throws IOException {
		FileWriter fw = new FileWriter(FILE, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(t.toString());
		bw.newLine();

		bw.close();
		fw.close();

	}

}

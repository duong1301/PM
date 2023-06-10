/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default
 * .txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package entities;

/**
 * @author LA
 */
public class Ticket implements Comparable<Ticket> {
	String ticketNum;

	public Ticket(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	@Override
	public String toString() {
		return this.ticketNum;
	}

	@Override
	public int compareTo(Ticket o) {
		return this.ticketNum.compareTo(o.getTicketNum());
	}
}

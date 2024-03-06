package com.gl.AssignmentSpring.service;

import java.util.List;

import com.gl.AssignmentSpring.model.Ticket;

public interface TicketService {
	void addTicket(Ticket ticket);

	Ticket getTicketById(int id);

	void updateTicketById(int id, Ticket t);

	void deleteTicketById(int id);

	List<Ticket> getAllTickets();

	List<Ticket> findByTitle(String title);
}

package com.gl.AssignmentSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.AssignmentSpring.dao.TicketDao;
import com.gl.AssignmentSpring.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDao ticketDao;

	@Override
	public void addTicket(Ticket ticket) {
		ticketDao.save(ticket);
	}

	@Override
	public Ticket getTicketById(int id) {
		Optional<Ticket> result = ticketDao.findById(id);
		if (!result.isEmpty()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateTicketById(int id, Ticket t) {
		Ticket ticket = ticketDao.findById(id).get();
		ticket.setTitle(t.getTitle());
		ticket.setDescription(t.getDescription());
		ticket.setDate(t.getDate());
		ticketDao.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		Optional<Ticket> ticket = ticketDao.findById(id);
		if (ticket.isPresent()) {
			ticketDao.delete(ticket.get());
		}
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketDao.findAll();
	}

	@Override
	public List<Ticket> findByTitle(String title) {
		// TODO Auto-generated method stub
		return ticketDao.findByTitle(title);
	}

}

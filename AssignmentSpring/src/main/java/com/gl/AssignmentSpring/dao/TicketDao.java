package com.gl.AssignmentSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.AssignmentSpring.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByTitle(String title);
}

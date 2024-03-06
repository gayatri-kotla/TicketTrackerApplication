package com.gl.AssignmentSpring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.AssignmentSpring.dao.TicketDao;
import com.gl.AssignmentSpring.model.Ticket;
import com.gl.AssignmentSpring.service.TicketService;

@SpringBootApplication
public class AssignmentSpringApplication implements CommandLineRunner {
	@Autowired
	TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ticketService.addTicket(new Ticket(1, "ticket 1", "title Description", "2022-12-27"));
		ticketService.addTicket(new Ticket(2, "ABCD", "ABCD", "2022-12-27"));

	}

}

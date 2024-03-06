package com.gl.AssignmentSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.AssignmentSpring.model.Ticket;
import com.gl.AssignmentSpring.service.TicketService;

@Controller
public class MyController {
	@Autowired
	TicketService ticketService;

	@RequestMapping("/admin")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/newticket")
	public String newTicket(Model m) {
		m.addAttribute("newticket", new Ticket());
		return "createticket";
	}

	@RequestMapping("/tickets")
	public String listOfTickets(Model m) {
		List<Ticket> list = ticketService.getAllTickets();
		m.addAttribute("tickets", list);
		return "ticketslist";
	}

	@RequestMapping("/editpage{id}")
	public String editpage(@PathVariable int id, Model m) {
		Ticket ticket1 = ticketService.getTicketById(id);
		m.addAttribute("ticket", ticket1);
		return "editticket";
	}

	@RequestMapping("/ticketcreated")
	public String newticket(@ModelAttribute Ticket newticket) {
		ticketService.addTicket(newticket);
		return "redirect:/admin";
	}

	@RequestMapping("/saveedit")
	public String savedetails(@ModelAttribute Ticket title) {
		ticketService.updateTicketById(title.getId(), title);
		return "redirect:/admin";
	}

	@RequestMapping("/deletepage{id}")
	public String deletepage(@PathVariable int id) {
		Ticket ticket1 = ticketService.getTicketById(id);
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@RequestMapping("/search")
	public String search(@RequestParam String title, Model m) {
		List<Ticket> ticket = ticketService.findByTitle(title);
		m.addAttribute("ticket", ticket);
		return "searchticket";
	}

	@RequestMapping("/viewpage{id}")
	public String viewpage(@PathVariable int id, Model m) {
		Ticket ticketById = ticketService.getTicketById(id);
		m.addAttribute("viewticket", ticketById);
		return "viewticket";
	}

}

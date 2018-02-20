package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.service.IClubesService;

@Controller
@RequestMapping(value="/clubes")
public class ClubesController {
	
	@Autowired
	private IClubesService serviceClubes;

}

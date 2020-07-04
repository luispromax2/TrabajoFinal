package pe.edu.upc.compraencasa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.compraencasa.model.entity.Factura;
import pe.edu.upc.compraencasa.model.entity.Factura;
import pe.edu.upc.compraencasa.service.FacturaService;
import pe.edu.upc.compraencasa.service.FacturaService;

@Controller
@RequestMapping("compraencasa/factura")
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private FacturaService compraService;
	
	@GetMapping
	public String listAll(Model model) {
		
		try {
			List<Factura> facturas = facturaService.readAll();
			model.addAttribute("facturas", facturas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Factura/listall";
	}
	
	
	

}

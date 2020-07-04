package pe.edu.upc.compraencasa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.compraencasa.model.entity.Compra;
import pe.edu.upc.compraencasa.model.entity.Producto;
import pe.edu.upc.compraencasa.service.CompraService;
import pe.edu.upc.compraencasa.service.FacturaService;
import pe.edu.upc.compraencasa.service.ProductoService;


@Controller
@RequestMapping("compraencasa/compras")
@SessionAttributes("compra")
public class CompraController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CompraService compraService;
	
	@Autowired 
	private FacturaService facturaService;
	@GetMapping
	public String listAll(Model model) {
		
		try {
			List<Compra> compras = compraService.readAll();
			model.addAttribute("compras", compras);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/Compra/listall";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		Compra compra = new Compra();
		model.addAttribute("compra",compra);
		try {
			List<Producto> productos = productoService.readAll();
			model.addAttribute("productos", productos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "/compra/nuevaCompra";
		
	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("compra")Compra compra,BindingResult result, Model model ,SessionStatus status) {
		
		if(result.hasErrors()) {
			try {
				List<Producto> productos = productoService.readAll();
				model.addAttribute("productos", productos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return "/compra/nuevaCompra";
		}else
			try {
				compraService.create(compra);
				status.setComplete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return "redirect:/compraencasa/compras";
	}
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Compra> optional = compraService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("compra", optional.get());
				
				List<Producto> productos = productoService.readAll();
				model.addAttribute("productos", productos);
			}
			else {
				return "redirect:/compraencasa/compras";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/compra/editCompra";
	}
	
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			
			Optional<Compra> optional = compraService.findById(id);
			if(optional.isPresent()) 
			{
				compraService.deleteById(id);
			}else {
				return "redirect:/compraencasa/compras";
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "redirect:/compraencasa/compras";
	}
	
	
	
	
	@GetMapping("/comprafactura")
	public String del(Model model) {
		try {
			
			List<Compra> optional = compraService.readAll();
			if(!optional.isEmpty()) 
			{
				compraService.deleteAll();
			}else {
				return "redirect:/compraencasa/compras";
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "redirect:/compraencasa/compras";
	}
	
	@GetMapping("/mensaje")
	public String mensaje(Model model) {
		try {
		List<Compra> optional = compraService.readAll();
		if(!optional.isEmpty()) 
		{
			compraService.deleteAll();
		}else {
			return "redirect:/compraencasa/compras";
		} 
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "/compra/mensajeCompra";
	
	}
}

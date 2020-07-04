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

import pe.edu.upc.compraencasa.model.entity.Vendedor;
import pe.edu.upc.compraencasa.service.VendedorService;

@Controller
@RequestMapping("compraencasa/vendedor")
@SessionAttributes("vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String star(Model model) {
		
		try {
			List<Vendedor> vendedores = vendedorService.readAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/Vendedor/starVendedor";
	}
	
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		Vendedor vendedor = new Vendedor();
		model.addAttribute("vendedor", vendedor);
		return "/Vendedor/nuevoVendedor";
		
	}
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("vendedor")Vendedor vendedor,BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			return "/Vendedor/nuevoVendedor";
		}else
		try {
			vendedorService.create(vendedor);
			status.setComplete();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/compraencasa/vendedor";
	}
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") Integer id,  Model model) {
		
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("vendedor", optional.get());
			}else {
				return "redirect:/compraencasa/vendedor";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/vendedor/editVendedor";
	}
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			
			Optional<Vendedor> optional = vendedorService.findById(id);
			if(optional.isPresent()) 
			{
				vendedorService.deleteById(id);
			}else {
				return "redirect:/compraencasa/vendedor";
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "redirect:/compraencasa/vendedor";
	}

}

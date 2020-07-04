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

import pe.edu.upc.compraencasa.model.entity.Producto;
import pe.edu.upc.compraencasa.model.entity.Vendedor;
import pe.edu.upc.compraencasa.service.ProductoService;
import pe.edu.upc.compraencasa.service.VendedorService;

@Controller
@RequestMapping("compraencasa/productos")
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String listAll(Model model) {
		
		try {
			List<Producto> productos = productoService.readAll();
			model.addAttribute("productos", productos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/Producto/listall";
	}
	@GetMapping("/new")
	public String nuevo(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		try {
			List<Vendedor> vendedores = vendedorService.readAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "/producto/nuevoProducto";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("producto")Producto producto,BindingResult result, Model model ,SessionStatus status) {
		if(result.hasErrors()) {
			try {
				List<Vendedor> vendedores = vendedorService.readAll();
				model.addAttribute("vendedores", vendedores);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return "/producto/nuevoProducto";
		}else
		try {
			productoService.create(producto);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/compraencasa/productos";
	}
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Producto> optional = productoService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("producto", optional.get());
				
				List<Vendedor> vendedores = vendedorService.readAll();
				model.addAttribute("vendedores", vendedores);
			}
			else {
				return "redirect:/compraencasa/productos";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/producto/editProducto";
	}
	
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			
			Optional<Producto> optional = productoService.findById(id);
			if(optional.isPresent()) 
			{
				productoService.deleteById(id);
			}else {
				return "redirect:/compraencasa/productos";
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "redirect:/compraencasa/productos";
	}
	
	@GetMapping("/compra/{id}")
	public String comprar() {
		return "/producto/productoCliente";
	}
}

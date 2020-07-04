package pe.edu.upc.compraencasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.compraencasa.model.entity.Usuario;
import pe.edu.upc.compraencasa.service.UsuarioService;

@Controller
@RequestMapping("compraencasa/signupseller")
@SessionAttributes("usuarioseller")
public class SignUpSellerController {

	@Autowired
	private UsuarioService usuarioServiceseller;
	
	@Autowired
	private PasswordEncoder passwordEncoderseller;
	
	private String passwordseller;
	
	@GetMapping
	public String start(Model model) {
		Usuario usuarioseller = new Usuario();
		usuarioseller.addAuthority("ROLE_SELLER");
		usuarioseller.addAuthority("ACCESS_ADDUSERVENDEDOR");
		usuarioseller.addAuthority("ACCESS_ADDPRODUCTOAVENDER");
		usuarioseller.addAuthority("ACCESS_EDITPRODUCTOAVENDER");
		usuarioseller.addAuthority("ACCESS_DELPRODUCTOAVENDER");
		
		model.addAttribute("usuarioseller", usuarioseller);
		return "/usuario/signupseller";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("usuarioseller") Usuario usuarioseller, Model model, SessionStatus status) {
		try {
			this.passwordseller = usuarioseller.getPassword();
			usuarioseller.setPassword( passwordEncoderseller.encode(this.passwordseller));
			usuarioServiceseller.create(usuarioseller);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/compraencasa/login";
	}
}
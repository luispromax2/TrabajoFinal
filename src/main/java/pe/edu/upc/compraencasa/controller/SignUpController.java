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
@RequestMapping("compraencasa/signup")
@SessionAttributes("usuario")
public class SignUpController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private String password;
	
	@GetMapping
	public String start(Model model) {
		Usuario usuario = new Usuario();
		usuario.addAuthority("ROLE_BUYER");
		usuario.addAuthority("ACCESS_ADDUSERCOMPRADOR");
		usuario.addAuthority("ACCESS_ADDPRODUCTOACOMPRAR");
		usuario.addAuthority("ACCESS_EDITPRODUCTOACOMPRAR");
		usuario.addAuthority("ACCESS_DELPRODUCTOACOMPRAR");
		usuario.addAuthority("ACCESS_COMPRARPRODUCTO");
		usuario.setEnable(true);
		
		model.addAttribute("usuario", usuario);
		return "/usuario/signup";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
		try {
			this.password = usuario.getPassword();
			usuario.setPassword( passwordEncoder.encode(this.password));
			usuarioService.create(usuario);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/compraencasa/login";
	}
}

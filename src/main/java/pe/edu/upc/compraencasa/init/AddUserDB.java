package pe.edu.upc.compraencasa.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.compraencasa.controller.AuthorityRepository;
import pe.edu.upc.compraencasa.model.entity.Usuario;
import pe.edu.upc.compraencasa.model.repository.UsuarioRepository;

@Service
public class AddUserDB implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
	@Override
	public void run(String... args) throws Exception {
		/*Usuario comprador = new Usuario();
		comprador.setUsername("comprador1");
		comprador.setPassword(new BCryptPasswordEncoder().encode("comprador"));
		comprador.setEnable(true);
		
		Usuario vendedor= new Usuario();
		vendedor.setUsername("vendedor1");
		vendedor.setPassword(new BCryptPasswordEncoder().encode("vendedor"));
		vendedor.setEnable(true);
		
		Usuario admin= new Usuario();
		admin.setUsername("admin1");
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		admin.setEnable(true);
		
		comprador.addAuthority("ROLE_BUYER");
		comprador.addAuthority("ACCESS_ADDUSERCOMPRADOR");
		comprador.addAuthority("ACCESS_ADDPRODUCTOACOMPRAR");
		comprador.addAuthority("ACCESS_EDITPRODUCTOACOMPRAR");
		comprador.addAuthority("ACCESS_DELPRODUCTOACOMPRAR");
		comprador.addAuthority("ACCESS_COMPRARPRODUCTO");
		
		vendedor.addAuthority("ROLE_SELLER");
		vendedor.addAuthority("ACCESS_ADDUSERVENDEDOR");
		vendedor.addAuthority("ACCESS_ADDPRODUCTOAVENDER");
		vendedor.addAuthority("ACCESS_EDITPRODUCTOAVENDER");
		vendedor.addAuthority("ACCESS_DELPRODUCTOAVENDER");
		
		admin.addAuthority("ROLE_ADMIN");
		admin.addAuthority("ACCESS_PRODUCTOAGREGADO");
		admin.addAuthority("ACCESS_ADDUSERVENDEDOR");
		admin.addAuthority("ACCESS_ADDUSERCOMPRADOR");
		admin.addAuthority("ACCESS_EDITCOMPRADOR");
		admin.addAuthority("ACCESS_DELCOMPRADOR");
		admin.addAuthority("ACCESS_EDITVENDEDOR");
		admin.addAuthority("ACCESS_DELVENDEDOR");
		
		usuarioRepository.save(comprador);
		usuarioRepository.save(vendedor);
		usuarioRepository.save(admin);*/
		
		
	}

}

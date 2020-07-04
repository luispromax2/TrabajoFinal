package pe.edu.upc.compraencasa.service;

import java.util.Optional;

import pe.edu.upc.compraencasa.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername (String username) throws Exception;
}

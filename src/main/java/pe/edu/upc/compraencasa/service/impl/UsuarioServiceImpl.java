package pe.edu.upc.compraencasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.compraencasa.model.entity.Usuario;
import pe.edu.upc.compraencasa.service.UsuarioService;
import pe.edu.upc.compraencasa.model.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	@Override
	public Usuario create(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> readAll() throws Exception {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findById(Long id) throws Exception {
		return usuarioRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Usuario update(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		usuarioRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub		
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findByUsername(String username) throws Exception {
		return usuarioRepository.findByUsername(username);
	}


}

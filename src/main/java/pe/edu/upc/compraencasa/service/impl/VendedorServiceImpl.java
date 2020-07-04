package pe.edu.upc.compraencasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.compraencasa.model.entity.Vendedor;
import pe.edu.upc.compraencasa.model.repository.VendedorRepository;
import pe.edu.upc.compraencasa.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	@Transactional
	public Vendedor create(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> readAll() throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendedor> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findById(id);
	}

	@Override
	@Transactional
	public Vendedor update(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		vendedorRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		vendedorRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendedor> findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findByDni(dni);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendedor> findByCelular(String celular) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findByCelular(celular);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findByApellidos(String apellidos) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findByApellidos(apellidos);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findByNombres(String Nombres) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findByNombres(Nombres);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findByCorreo(String correo) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findByCorreo(correo);
	}
	
	

}

package pe.edu.upc.compraencasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.compraencasa.model.entity.Producto;
import pe.edu.upc.compraencasa.model.repository.ProductoRepository;
import pe.edu.upc.compraencasa.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional
	public Producto create(Producto entity) throws Exception {
		return productoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> readAll() throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	@Transactional
	public Producto update(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		productoRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		productoRepository.deleteAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombres(String Nombres) throws Exception {
		return productoRepository.findByNombres(Nombres);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByCosto(double costo) throws Exception {
		return productoRepository.findByCosto(costo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByCantidad(double cantidad) throws Exception {
		return productoRepository.findByCantidad(cantidad);
	}

}

package pe.edu.upc.compraencasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.compraencasa.model.entity.DetalleCarrito;
import pe.edu.upc.compraencasa.model.repository.DetalleCarritoRepository;
import pe.edu.upc.compraencasa.service.DetalleCompraService;

public class DetalleCarritoServiceImpl implements DetalleCompraService{

	
	@Autowired
	private DetalleCarritoRepository detalleCarritoRepository;
	
	@Override
	@Transactional
	public DetalleCarrito create(DetalleCarrito entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleCarrito> readAll() throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleCarrito> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.findById(id);
	}

	@Override
	@Transactional
	public DetalleCarrito update(DetalleCarrito entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleCarritoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		detalleCarritoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		detalleCarritoRepository.deleteAll();
	}

}

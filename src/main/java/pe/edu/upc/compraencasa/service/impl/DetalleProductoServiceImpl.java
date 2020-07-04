package pe.edu.upc.compraencasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.compraencasa.model.entity.DetalleProducto;
import pe.edu.upc.compraencasa.model.repository.DetalleProductoRepository;
import pe.edu.upc.compraencasa.service.DetalleProductoService;

public class DetalleProductoServiceImpl implements DetalleProductoService{

	@Autowired
	private DetalleProductoRepository detalleProductoRepository;
	
	@Override
	@Transactional
	public DetalleProducto create(DetalleProducto entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleProductoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleProducto> readAll() throws Exception {
		// TODO Auto-generated method stub
		return detalleProductoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleProducto> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detalleProductoRepository.findById(id);
	}

	@Override
	@Transactional
	public DetalleProducto update(DetalleProducto entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleProductoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		detalleProductoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		detalleProductoRepository.deleteAll();
	}
	

}

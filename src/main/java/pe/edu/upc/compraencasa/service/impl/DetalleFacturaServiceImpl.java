package pe.edu.upc.compraencasa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.compraencasa.model.entity.DetalleFactura;
import pe.edu.upc.compraencasa.model.repository.DetalleFacturaRepository;
import pe.edu.upc.compraencasa.service.DetalleFacturaService;

public class DetalleFacturaServiceImpl implements DetalleFacturaService {

	@Autowired
	private DetalleFacturaRepository detalleFacturaRepository; 
	
	@Override
	@Transactional
	public DetalleFactura create(DetalleFactura entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleFacturaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleFactura> readAll() throws Exception {
		// TODO Auto-generated method stub
		return detalleFacturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleFactura> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detalleFacturaRepository.findById(id);
	}

	@Override
	@Transactional
	public DetalleFactura update(DetalleFactura entity) throws Exception {
		// TODO Auto-generated method stub
		return detalleFacturaRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		detalleFacturaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		detalleFacturaRepository.deleteAll();
	}

}

package pe.edu.upc.compraencasa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.compraencasa.model.entity.Compra;


@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer>{

	List<Compra> findByCantidad(double cantidad)throws Exception;
}

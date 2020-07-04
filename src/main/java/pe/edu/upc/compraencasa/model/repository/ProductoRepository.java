package pe.edu.upc.compraencasa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;*/
import org.springframework.stereotype.Repository;

import pe.edu.upc.compraencasa.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
	
	List<Producto> findByNombres(String Nombres)throws Exception;
	List<Producto> findByCosto(double costo)throws Exception;
	List<Producto> findByCantidad(double cantidad)throws Exception;
	
	/*
	@Query("SELECT p FROM Producto p WHERE p.costo= :costo")
	List<Producto> fetchByCosto(double costo)throws Exception;
	
	@Query
	List<Producto> fetchByCantidad(double cantidad)throws Exception;
	*/
}

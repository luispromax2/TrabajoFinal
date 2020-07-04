package pe.edu.upc.compraencasa.service;

import java.util.List;

import pe.edu.upc.compraencasa.model.entity.Producto;

public interface ProductoService extends CrudService<Producto,Integer>{
	List<Producto> findByNombres(String Nombres)throws Exception;
	List<Producto> findByCosto(double costo)throws Exception;
	List<Producto> findByCantidad(double cantidad)throws Exception;

}

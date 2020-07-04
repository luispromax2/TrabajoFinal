package pe.edu.upc.compraencasa.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.compraencasa.model.entity.Vendedor;

public interface VendedorService extends CrudService<Vendedor,Integer>{
	Optional<Vendedor> findByDni(String dni) throws Exception;
	Optional<Vendedor> findByCelular(String celular) throws Exception;
	List<Vendedor> findByApellidos(String apellidos)throws Exception;
	List<Vendedor> findByNombres(String Nombres)throws Exception;
	List<Vendedor> findByCorreo(String correo)throws Exception;

}

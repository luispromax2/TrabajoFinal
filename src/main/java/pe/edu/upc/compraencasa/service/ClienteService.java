package pe.edu.upc.compraencasa.service;

import java.util.List;

import pe.edu.upc.compraencasa.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente,Integer>{
	List<Cliente> findByApellidos(String apellidos)throws Exception;
	List<Cliente> findByNombres(String Nombres)throws Exception;
	List<Cliente> findByDistrito(String distrito)throws Exception;
	List<Cliente> findByCorreo(String correo)throws Exception;
	List<Cliente> fetchByDistrito(String distrito)throws Exception;


}

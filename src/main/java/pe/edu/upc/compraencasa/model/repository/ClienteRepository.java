package pe.edu.upc.compraencasa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.compraencasa.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
	List<Cliente> findByApellidos(String apellidos)throws Exception;
	List<Cliente> findByNombres(String Nombres)throws Exception;
	List<Cliente> findByDistrito(String distrito)throws Exception;
	List<Cliente> findByCorreo(String correo)throws Exception;
	
	@Query("SELECT d FROM Cliente d WHERE d.distrito like %:distrito")

	List<Cliente> fetchByDistrito(String distrito)throws Exception;

}

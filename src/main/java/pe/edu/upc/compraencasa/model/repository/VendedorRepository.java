package pe.edu.upc.compraencasa.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.compraencasa.model.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Integer>{
	
	Optional<Vendedor> findByDni(String dni) throws Exception;
	Optional<Vendedor> findByCelular(String celular) throws Exception;
	List<Vendedor> findByApellidos(String apellidos)throws Exception;
	List<Vendedor> findByNombres(String Nombres)throws Exception;
	List<Vendedor> findByCorreo(String correo)throws Exception;

}

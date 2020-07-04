package pe.edu.upc.compraencasa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.compraencasa.model.entity.DetalleProducto;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto,Integer> {

}

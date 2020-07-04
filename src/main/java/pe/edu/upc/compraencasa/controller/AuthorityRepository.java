package pe.edu.upc.compraencasa.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.compraencasa.model.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}

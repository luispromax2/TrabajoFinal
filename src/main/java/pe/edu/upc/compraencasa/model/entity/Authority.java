package pe.edu.upc.compraencasa.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.compraencasa.model.entity.Usuario;

@Entity
@Table(name = "authorities",
uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})})
@Getter
@Setter
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30, nullable = false)
	private String authority;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Usuario usuario;
	// getter y setter
}

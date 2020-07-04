package pe.edu.upc.compraencasa.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@NotBlank(message ="No puede estar vacio")
	@Column(name = "apellidos",length = 50,nullable = false)
	private String apellidos;
	
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "nombres",length = 30,nullable = false)
	private String nombres;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "correo", length = 50, nullable = false)
	private String correo;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "distrito",length = 40,nullable = false)
	private String distrito;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "password",length = 30,nullable = false)
	private String password;
	
	@Transient
	private String confPassword;
	
	//@NotEmpty(message ="Un cliente debe tener un factura")
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	public Cliente() {
		productos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
		
	}
	
}

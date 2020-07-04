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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vendedores")
@Getter
@Setter
public class Vendedor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "nombres",length = 30,nullable = false)
	private String nombres;

	@NotBlank(message ="No puede estar vacio")
	@Column(name = "apellidos",length = 30,nullable = false)
	private String apellidos;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "password",length = 30,nullable = false)
	private String password;
	
	@Size(min=8, max=8,message ="Debe tener 8 digitos")
	@Column(name = "dni", length =8, nullable = false)
	private String dni;
	
	@Size(min=9, max=9,message ="Debe tener 9 digitos")
	@Column(name = "celular", length =8, nullable = false)
	private String celular;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "correo", length = 50, nullable = false)
	private String correo;
	
	@OneToMany(mappedBy = "vendedor",fetch = FetchType.LAZY)
	private  List<Producto> productos;
	
	public Vendedor() {
		productos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}


}

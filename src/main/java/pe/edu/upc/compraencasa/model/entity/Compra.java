package pe.edu.upc.compraencasa.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "compras")
@Getter
@Setter
public class Compra {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@FutureOrPresent(message ="Debe ser presente o futuro el dato")
	@Column(name = "fecha_compra",nullable = false)
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCompra;
	
	@OneToOne(mappedBy="compra",fetch = FetchType.LAZY)
	@JoinColumn(name="factura_id")
	private Factura factura;
	
	
	@OneToOne(mappedBy="compra",fetch = FetchType.LAZY)
	@JoinColumn(name="detalleCarrito_id",nullable = true)
	private DetalleCarrito detalleCarrito;
	
	@NotNull(message = "No puede estar vacío")
	@OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "cantidad",length = 50,nullable = false)
	private String cantidad;
	
	@NotNull(message = "No puede estar vacío")
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Producto producto;
	
	public Compra() {
		productos = new ArrayList<>();
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
	
	
}

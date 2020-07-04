package pe.edu.upc.compraencasa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle_Facturas")
@Getter
@Setter
public class DetalleFactura {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="No puede estar vacio")
    @Column(name = "descripcion",length = 200,nullable = false)
    private String descripcion;

    @OneToOne(fetch = FetchType.LAZY)
    private Factura factura;



}

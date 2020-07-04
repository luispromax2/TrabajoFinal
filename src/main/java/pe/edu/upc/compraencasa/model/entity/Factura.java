package pe.edu.upc.compraencasa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "facturas")
@Getter
@Setter
public class Factura {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message ="No puede estar vacio")
	@Column(name = "valor_total",nullable = false)
	private double valorTotal;
	
	@OneToOne(fetch = FetchType.LAZY)
    private Compra compra;

    @OneToOne(mappedBy="factura",fetch = FetchType.LAZY)
    @JoinColumn(name="detalleFactura_id", updatable = false, nullable = false)
    private DetalleFactura detalleFactura;
}

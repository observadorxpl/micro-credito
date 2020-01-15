package com.productocredito.app.models;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class ProductoCredito {
	@Id
	private String idProducto;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private Date fechaCreacion;
		
	private double intereses;
	@Valid
	private TipoProducto tipoProducto;
	public ProductoCredito(@NotEmpty String descripcion, @NotEmpty Date fechaCreacion, double intereses,
			@Valid TipoProducto tipoProducto) {
		super();
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.intereses = intereses;
		this.tipoProducto = tipoProducto;
	}

}

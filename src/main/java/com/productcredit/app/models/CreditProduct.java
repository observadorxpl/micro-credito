package com.productcredit.app.models;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreditProduct {
	@Id
	private String idProduct;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private Date createAt;
		
	private double interest;
	@Valid
	private CreditProductType productType;
	

	public CreditProduct(@NotEmpty String description, @NotEmpty Date createAt, double interest,
			@Valid CreditProductType productType) {
		super();
		this.description = description;
		this.createAt = createAt;
		this.interest = interest;
		this.productType = productType;
	}

}

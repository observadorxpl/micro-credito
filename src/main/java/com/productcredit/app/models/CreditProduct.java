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
	@NotEmpty
	private Integer productCode;
	@Valid
	private CreditProductType productType;
	@Valid
	private Bank bank;

	public CreditProduct(@NotEmpty String description, @NotEmpty Date createAt, double interest,
			@NotEmpty Integer productCode, @Valid CreditProductType productType, @Valid Bank bank) {
		super();
		this.description = description;
		this.createAt = createAt;
		this.interest = interest;
		this.productCode = productCode;
		this.productType = productType;
		this.bank = bank;
	}

}

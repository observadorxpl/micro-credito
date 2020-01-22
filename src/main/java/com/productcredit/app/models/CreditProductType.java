package com.productcredit.app.models;

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
public class CreditProductType {
	@Id
	private String idProductType;

	@NotEmpty
	private String description;

	public CreditProductType(@NotEmpty String description) {
		super();
		this.description = description;
	}
	
}

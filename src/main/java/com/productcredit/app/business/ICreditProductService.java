package com.productcredit.app.business;
import com.productcredit.app.models.CreditProduct;
import com.productcredit.app.util.ICRUD;

import reactor.core.publisher.Flux;

public interface ICreditProductService extends ICRUD<CreditProduct>{
	Flux<CreditProduct> buscarPorCodigoBanco(String idBank);
}
	
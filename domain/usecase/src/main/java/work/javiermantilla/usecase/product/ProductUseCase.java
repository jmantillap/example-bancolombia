package work.javiermantilla.usecase.product;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import work.javiermantilla.model.product.Product;
import work.javiermantilla.model.product.gateways.ProductRepositoryPort;


@RequiredArgsConstructor
public class ProductUseCase {
	
	private final ProductRepositoryPort productRepositoryPort;
	
	public Mono<Product> getProduct(String id){
		/*
		 * Logica de negocio del caso de uso
		 */
		return this.productRepositoryPort.getProduct(id);
	}
	public Flux<Product> getList(){
		return this.productRepositoryPort.getListProduct();
	}
	
	public Mono<Product> save(Product producto) {
		return productRepositoryPort.save(producto);
	}
}

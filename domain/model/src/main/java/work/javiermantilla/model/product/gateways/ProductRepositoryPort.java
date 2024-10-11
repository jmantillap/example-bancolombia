package work.javiermantilla.model.product.gateways;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import work.javiermantilla.model.product.Product;

public interface ProductRepositoryPort {
	Mono<Product> getProduct(String id);
	Flux<Product> getListProduct();
	Mono<Product> save(Product producto);
}

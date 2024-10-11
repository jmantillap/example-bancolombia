package work.javiermantilla.mongo;

import work.javiermantilla.model.product.Product;
import work.javiermantilla.model.product.gateways.ProductRepositoryPort;
import work.javiermantilla.mongo.document.ProductDocument;
import work.javiermantilla.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Log4j2
public class MongoRepositoryProductAdapter 
	extends AdapterOperations<Product, ProductDocument, String, MongoDBProductRepository>
 implements ProductRepositoryPort
{
	
    public MongoRepositoryProductAdapter(MongoDBProductRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Product.class));
    }

	@Override
	public Mono<Product> getProduct(String id) {				
		return this.repository
				.findById(id)
				.map(p->toEntity(p))
				.doOnNext(p-> log.info("Producto {}",p.getNombre()) )
				//.switchIfEmpty(Mono.just(new Product()))
				;
	}

	@Override
	public Flux<Product> getListProduct() {
		return this.repository.findAll()
				.map(p-> toEntity(p));
	}
}

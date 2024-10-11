package work.javiermantilla.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

import work.javiermantilla.mongo.document.ProductDocument;

public interface MongoDBProductRepository 
	extends ReactiveMongoRepository<ProductDocument, String>, ReactiveQueryByExampleExecutor<ProductDocument> {
}

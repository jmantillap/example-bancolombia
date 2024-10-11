package work.javiermantilla.mongo.helper;

import work.javiermantilla.model.product.Product;
import work.javiermantilla.mongo.MongoDBProductRepository;
import work.javiermantilla.mongo.MongoRepositoryProductAdapter;
import work.javiermantilla.mongo.document.ProductDocument;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AdapterOperationsTest {

//    @Mock
//    private MongoDBProductRepository repository;
//
//    @Mock
//    private ObjectMapper objectMapper;

//    private MongoRepositoryProductAdapter adapter;
//
//    private Product entity;
//    private ProductDocument document;
//    
//    private Flux<Product> entities;
//    
//    private Flux<ProductDocument> documents;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        document= new ProductDocument();
//        entity = new Product();
//        
//        when(objectMapper.map(entity, ProductDocument.class)).thenReturn(document);
//
//        adapter = new MongoRepositoryProductAdapter(repository, objectMapper);
//
//        
//        entities = Flux.just(entity);
//        documents = Flux.just(document);
//    }

//    @Test
//    void testSave() {
//        when(repository.save(document)).thenReturn(Mono.just(new ProductDocument()));
//        StepVerifier.create(adapter.save(entity))
//                .expectNext(entity)
//                .verifyComplete();
//    }
//
//    @Test
//    void testSaveAll() {
//        //when(repository.saveAll(any(Flux.class))).thenReturn(entities);
//
//        StepVerifier.create(adapter.saveAll(entities))
//                .expectNext(entity)
//                .verifyComplete();
//    }
//
//    @Test
//    void testFindById() {
//        when(repository.findById("key")).thenReturn(Mono.just(document));
//
//        StepVerifier.create(adapter.findById("key"))
//                .expectNext(entity)
//                .verifyComplete();
//    }
//
//    @Test
//    void testFindByExample() {
//        //when(repository.findAll(any(Example.class))).thenReturn(entities);
//        StepVerifier.create(adapter.findByExample(entity))
//                .expectNext(entity)
//                .verifyComplete();
//    }
//
//    @Test
//    void testFindAll() {
//        when(repository.findAll()).thenReturn(documents);
//
//        StepVerifier.create(adapter.findAll())
//                .expectNext(entity)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeleteById() {
//        when(repository.deleteById("key")).thenReturn(Mono.empty());
//
//        StepVerifier.create(adapter.deleteById("key"))
//                .verifyComplete();
//    }
}

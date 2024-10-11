package work.javiermantilla;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import work.javiermantilla.model.product.Product;
import work.javiermantilla.usecase.product.ProductUseCase;

@SpringBootApplication
@RequiredArgsConstructor // para inicializar valores demo en la base de datos de mongo
@Log4j2 
public class MainApplication implements CommandLineRunner {

	//atributos temporales de prueba para alimentar la base de datos mongo-db
	private final ReactiveMongoTemplate mongoTemplate;
	private final ProductUseCase productUseCase;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	/**
	 * Metodo inicial para alimentar la base de datos mongo-db
	 */
	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("productos").subscribe();
// 		mongoTemplate.dropCollection("categorias").subscribe();
//		Categoria electronico = new Categoria("Electrónico");
//		Categoria deporte = new Categoria("Deporte");
//		Categoria computacion = new Categoria("Computación");
//		Categoria muebles = new Categoria("Muebles");

		Flux.just(new Product("TV Panasonic Pantalla LCD", 456.89),
				new Product("Sony Camara HD Digital", 177.89),
				new Product("Apple iPod", 46.89), 
				new Product("Sony Notebook", 846.89),
				new Product("Hewlett Packard Multifuncional", 200.89),
				new Product("Bianchi Bicicleta", 70.89),
				new Product("HP Notebook Omen 17", 2500.89),
				new Product("Mica Cómoda 5 Cajones", 150.89),
				new Product("TV Sony Bravia OLED 4K Ultra HD", 2255.89))
			.flatMap(producto -> {
					producto.setCreateAt(new Date());
					return productUseCase.save(producto);
			}).subscribe(producto -> log.info("Insert: " + producto.getId() + " " + producto.getNombre()));

	}

}

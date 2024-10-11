package work.javiermantilla.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.PropertiesMongoConnectionDetails;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {
	
	 	 
	//remove '_class’ field
	@Bean
	ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient
			, @Value("${spring.data.mongodb.database}") String database) {
		ReactiveMongoTemplate template = new ReactiveMongoTemplate(mongoClient,database );
		MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		converter.afterPropertiesSet();
		return template;
	}

//    @Bean
//    MongoDBSecret dbSecret(@Value("${spring.data.mongodb.uri}") String uri) {
//        return MongoDBSecret.builder()
//                .uri(uri)
//                .build();
//    }

//    @Bean
//    MongoConnectionDetails mongoProperties(MongoDBSecret secret) {
//        MongoProperties properties = new MongoProperties();
//        properties.setUri(secret.getUri());
//        return new PropertiesMongoConnectionDetails(properties);
//    }
    
//    @Bean
//    ReactiveMongoClientFactory mongoProperties(MongoDBSecret secret) {
//        List<MongoClientSettingsBuilderCustomizer> list = new ArrayList<>();
//        list.add(mongoDBDefaultSettings(secret.getUri()));
//        return new ReactiveMongoClientFactory(list);
//    }
//
//    public MongoClientSettingsBuilderCustomizer mongoDBDefaultSettings(String uri) {
//        return builder -> builder.applyConnectionString(new ConnectionString(uri))
//                .applyToSslSettings(
//                        blockBuilder -> blockBuilder.enabled(false)
//                );
//    }
}

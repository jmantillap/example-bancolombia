package work.javiermantilla.api;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import work.javiermantilla.model.product.Product;
import work.javiermantilla.usecase.product.ProductUseCase;

@Component
@RequiredArgsConstructor
public class HandlerProduct {
	private  final ProductUseCase productUseCase;
	//private  final UseCase2 useCase2;

    public Mono<ServerResponse> listenGETProduct(ServerRequest serverRequest) {        
    	String id = serverRequest.pathVariable("id");
    	
    	return productUseCase.getProduct(id)
    		.flatMap(p-> 
	    		ServerResponse.ok()
	    				.contentType(MediaType.APPLICATION_JSON)
	    				.bodyValue(p)
    		).switchIfEmpty(ServerResponse.badRequest().build());
    	
    }

    public Mono<ServerResponse> listenGETAllProduct(ServerRequest serverRequest) {        
        return 	ServerResponse.ok()
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.body(productUseCase.getList(),Product.class);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}

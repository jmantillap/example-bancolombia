package work.javiermantilla.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    RouterFunction<ServerResponse> routerFunction(HandlerProduct handler) {
        return route(GET("/api/product/{id}"), handler::listenGETProduct)        	
        		.andRoute(GET("/api/product"), handler::listenGETAllProduct)                
                ;
    }
}

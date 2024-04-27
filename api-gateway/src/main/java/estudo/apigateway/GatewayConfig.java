package estudo.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                    .path("/account/**")
                    .uri("lb://account-service")
                )
                .route(r -> r
                    .path("/transaction/**", "/transfer/**")
                    .uri("lb://transactions-service")
                ).build();
    }

}

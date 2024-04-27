package estudo.transactionsservice.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import estudo.transactionsservice.dto.ResponseData;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@Retry(name = "default", fallbackMethod = "fallback")
@RequestMapping("resilience")
public class ResilienceTestController extends BaseController {

    @GetMapping
    public ResponseEntity<ResponseData> get() {
        LoggerFactory.getLogger(this.getClass()).info("Request received!");
        return new RestTemplate().getForEntity("http://localhost:8000/account", 
            ResponseData.class);
    }

    @SuppressWarnings("unused")
    private ResponseEntity<Object> fallback(Exception error) {
        LoggerFactory.getLogger(this.getClass()).info(error.getMessage());
        return getResponse("Serviço Indisponível", HttpStatus.SERVICE_UNAVAILABLE);
    }

}

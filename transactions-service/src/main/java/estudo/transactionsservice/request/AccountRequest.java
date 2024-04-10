package estudo.transactionsservice.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import estudo.transactionsservice.dto.ResponseData;

@FeignClient(name = "account-service", url = "localhost:8000")
public interface AccountRequest {

    @GetMapping("/account/{account}")
    ResponseData getUserAccount(@PathVariable Long account);

}
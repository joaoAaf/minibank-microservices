package estudo.accountservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import estudo.accountservice.dto.CustomerSave;
import estudo.accountservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RequestMapping("account")
@RestController
public class CustomerController extends BaseController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<Object> postCustomer(@RequestBody CustomerSave customerDto) {
        try {
            return getResponse(service.save(customerDto),
                    "Conta Registrada com Sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

}

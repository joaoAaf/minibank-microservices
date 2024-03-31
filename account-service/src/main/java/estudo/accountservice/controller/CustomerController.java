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
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@RequestMapping("account")
@RestController
public class CustomerController extends BaseController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<Object> postCustomer(@RequestBody CustomerSave customerDto) {
        try {
            return getResponse(service.save(customerDto),
                    "Conta registrada com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllCustomer() {
        try {
            var customers = service.getAll();
            if (customers.size() == 0) {
                return getResponse("Não há contas cadastradas.", HttpStatus.NOT_FOUND);
            }
            return getResponse(customers, HttpStatus.OK);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}

package estudo.accountservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import estudo.accountservice.dto.CustomerSave;
import estudo.accountservice.dto.CustomerView;
import estudo.accountservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RequestMapping("account")
@RestController
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<CustomerView> postCustomer(@RequestBody CustomerSave customerDto) {
        CustomerView newCustomer = service.save(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

}

package estudo.accountservice.service;

import java.util.List;
import org.springframework.stereotype.Service;

import estudo.accountservice.dto.CustomerSave;
import estudo.accountservice.dto.CustomerView;
import estudo.accountservice.model.Customer;
import estudo.accountservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repo;

    public Customer fromDto(CustomerSave customerDto) {
        return Customer
            .builder()
            .cpf(customerDto.cpf())
            .name(customerDto.name())
            .enable(true)
            .build();
    }

    public CustomerView showCustomer(Customer customer) {
        return new CustomerView(customer.getAccount(), customer.getCpf(), customer.getName());
    }

    public CustomerView save(CustomerSave customerDto) {
        Customer customer = fromDto(customerDto);
        return showCustomer(repo.save(customer));
    }

    // public List<CustomerView> getAll() {
    //     var customers = repo.findAll();
    //     return customers.stream()
    //         .map(c -> showCustomer(c))
    //         .collect(Collectors.toList());
    // }

    public List<Customer> getAll() {
        var customers = repo.findAll();
        System.out.println(customers);
        return customers;
    }

}

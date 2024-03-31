package estudo.accountservice.service;

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

    // public CustomerService(CustomerRepository repo) {
    //     this.repo = repo;
    // }

    public Customer fromDto(CustomerSave customerDto) {
        return new Customer("123", customerDto.cpf(), customerDto.fullName(), true);
    }

    public CustomerView showCustomer(Customer customer) {
        return new CustomerView(customer.getAccountNum(), customer.getCpf(), customer.getFullName());
    }
    
    public CustomerView save(CustomerSave customerDto) {
        Customer customer = fromDto(customerDto);
        return showCustomer(repo.save(customer));
    }



}

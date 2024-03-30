package estudo.accountservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "client")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account",nullable = false, unique = true)
    private String accountNum;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name = "name",nullable = false, length = 100)
    private String fullName;
    @Column(nullable = false)
    private boolean enable;

}

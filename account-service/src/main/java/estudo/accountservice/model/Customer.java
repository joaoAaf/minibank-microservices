package estudo.accountservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "client")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private boolean enable;

}

package estudo.transactionsservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import estudo.transactionsservice.util.Operation;
import lombok.Data;

@Data
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String Id;
    @NonNull
    private Long account;
    @NonNull
    private LocalDateTime dateTime;
    @NonNull
    private BigDecimal value;
    @NonNull
    private Operation operation;

}

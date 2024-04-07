package estudo.transactionsservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import estudo.transactionsservice.util.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String id;
    @NonNull
    private Long account;
    @NonNull
    private LocalDateTime dateTime;
    @NonNull
    private BigDecimal value;
    @NonNull
    private Operation operation;

}

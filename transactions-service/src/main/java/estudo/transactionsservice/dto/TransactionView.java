package estudo.transactionsservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import estudo.transactionsservice.util.Operation;
import lombok.Builder;

@Builder
public record TransactionView(String id, Long account, LocalDateTime dateTime, 
    BigDecimal value, Operation operation) {

}

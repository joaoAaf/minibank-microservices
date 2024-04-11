package estudo.transactionsservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import estudo.transactionsservice.util.Operation;
import lombok.Builder;

@Builder
@JsonInclude(value = Include.NON_NULL)
public record TransactionView(String id, Long account, LocalDateTime dateTime, 
    BigDecimal value, Operation operation) {

}

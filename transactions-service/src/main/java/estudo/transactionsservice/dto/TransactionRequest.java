package estudo.transactionsservice.dto;

import java.math.BigDecimal;

import estudo.transactionsservice.util.Operation;

public record TransactionRequest(Long account, Operation operation, BigDecimal value) {

}

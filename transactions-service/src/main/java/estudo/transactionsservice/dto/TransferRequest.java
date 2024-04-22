package estudo.transactionsservice.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Positive;

public record TransferRequest(Long accountFrom, Long accountTo, @Positive BigDecimal value) {

}

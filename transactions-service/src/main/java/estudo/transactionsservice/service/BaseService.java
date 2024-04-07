package estudo.transactionsservice.service;

import java.time.LocalDateTime;

import estudo.transactionsservice.dto.TransactionRequest;
import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.model.Transaction;

public class BaseService {

    protected Transaction fromDto(TransactionRequest requestDto) {
        return Transaction.builder()
            .account(requestDto.account())
            .operation(requestDto.operation())
            .dateTime(LocalDateTime.now())
            .value(requestDto.value())
            .build();
    }

    protected TransactionView toDto(Transaction transaction) {
        return TransactionView.builder()
            .id(transaction.getId())
            .account(transaction.getAccount())
            .dateTime(transaction.getDateTime())
            .value(transaction.getValue())
            .operation(transaction.getOperation())
            .build();
    }

}

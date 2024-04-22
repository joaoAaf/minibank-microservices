package estudo.transactionsservice.service;

import java.time.LocalDateTime;

import estudo.transactionsservice.dto.TransactionRequest;
import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.dto.TransferRequest;
import estudo.transactionsservice.model.Transaction;
import estudo.transactionsservice.model.Transfer;

public class BaseService {

    protected Transaction fromDto(TransactionRequest requestDto) {
        return Transaction.builder()
                .account(requestDto.account())
                .operation(requestDto.operation())
                .dateTime(LocalDateTime.now())
                .value(requestDto.value())
                .build();
    }

    protected Transfer fromDto(TransferRequest requestDto) {
        return Transfer.builder()
                .accountFrom(requestDto.accountFrom())
                .accountTo(requestDto.accountTo())
                .dateTime(LocalDateTime.now())
                .value(requestDto.value())
                .build();
    }

    protected TransactionView toDto(Transaction transaction) {
        return TransactionView.builder()
                .id(transaction.getId())
                .accountFrom(transaction.getAccount())
                .dateTime(transaction.getDateTime())
                .value(transaction.getValue())
                .operation(transaction.getOperation())
                .build();
    }

    protected TransactionView toDto(Transfer transfer) {
        return TransactionView.builder()
                .id(transfer.getId())
                .accountFrom(transfer.getAccountFrom())
                .accountTo(transfer.getAccountTo())
                .dateTime(transfer.getDateTime())
                .value(transfer.getValue())
                .build();
    }

}

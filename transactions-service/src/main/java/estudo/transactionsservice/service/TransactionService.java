package estudo.transactionsservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import estudo.transactionsservice.dto.AccountStatement;
import estudo.transactionsservice.dto.TransactionRequest;
import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.repository.TransactionRepository;
import estudo.transactionsservice.repository.TransferRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionService extends BaseService {

    private final TransactionRepository repoTransaction;
    private final TransferRepository repoTransfer;

    public TransactionView save(TransactionRequest requestDto) {
        return toDto(repoTransaction.save(fromDto(requestDto)));
    }

    public AccountStatement accountStatement(Long account) {
        var statement = new AccountStatement();
        statement.setAccount(account);
        statement.setTransactions(getAllTransactions(account));
        statement.calculateBalance();
        return statement;
    }

    private List<TransactionView> getAllTransactions(Long account) {
        var allTransactions = new ArrayList<TransactionView>();
        var transactions = repoTransaction.getTransactionsByAccount(account);
        var transfers = repoTransfer.getTransfersByAccountFrom(account);
        transfers.forEach(t -> t.setValue(t.getValue().multiply(new BigDecimal(- 1))));
        transfers.addAll(repoTransfer.getTransfersByAccountTo(account));
        // itera sobre a lista de transações e chama o método toDto para cada elemento da lista
        allTransactions.addAll(transactions.stream().map(this::toDto).toList());
        allTransactions.addAll(transfers.stream().map(this::toDto).toList());
        return allTransactions;
    }

}

package estudo.transactionsservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import estudo.transactionsservice.dto.AccountStatement;
import estudo.transactionsservice.dto.TransactionRequest;
import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionService extends BaseService {

    private final TransactionRepository repo;
    private final TransferService transferService;

    public TransactionView save(TransactionRequest requestDto) {
        return toDto(repo.save(fromDto(requestDto)));
    }

    public AccountStatement accountStatement(Long account) {
        var statement = new AccountStatement();
        statement.setAccount(account);
        statement.setTransactions(getAllTransactions(account));
        statement.calculateBalance();
        return statement;
    }

    private List<TransactionView> findByAccount(Long account) {
        var transactions = repo.getTransactionsByAccount(account);
        // itera sobre a lista de transações e chama o método toDto para cada elemento
        return transactions.stream().map(this::toDto).collect(Collectors.toList());
    }

    private List<TransactionView> getAllTransactions(Long account) {
        var allTransactions = findByAccount(account);
        allTransactions.addAll(transferService.findByAccount(account));
        return allTransactions;
    }

}

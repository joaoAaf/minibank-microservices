package estudo.transactionsservice.service;

import org.springframework.stereotype.Service;

import estudo.transactionsservice.dto.TransactionRequest;
import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionService extends BaseService {

    private final TransactionRepository repo;

    public TransactionView save(TransactionRequest requestDto) {
        return toDto(repo.save(fromDto(requestDto)));
    }

}

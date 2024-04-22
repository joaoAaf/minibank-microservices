package estudo.transactionsservice.service;

import org.springframework.stereotype.Service;

import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.dto.TransferRequest;
import estudo.transactionsservice.repository.TransferRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransferService extends BaseService {

    private final TransferRepository repo;

    public TransactionView save(TransferRequest requestDto) {
        return toDto(repo.save(fromDto(requestDto)));
    }

}

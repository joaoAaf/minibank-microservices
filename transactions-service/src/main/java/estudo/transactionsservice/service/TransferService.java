package estudo.transactionsservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import estudo.transactionsservice.dto.TransactionView;
import estudo.transactionsservice.dto.TransferRequest;
import estudo.transactionsservice.repository.TransferRepository;
import estudo.transactionsservice.util.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransferService extends BaseService {

    private final TransferRepository repo;

    public TransactionView save(TransferRequest requestDto) {
        return toDto(repo.save(fromDto(requestDto)));
    }

    public List<TransactionView> findByAccount(Long account) {
        return repo.getTransfersByAccount(account)
                .stream()
                .map(t -> {
                    if(t.getAccountFrom().equals(account)) {
                        t.setValue(t.getValue().negate());
                        return toDto(t, Operation.transferSend);
                    }
                    return toDto(t, Operation.transferReceived);
                })
                .toList();
    }

}

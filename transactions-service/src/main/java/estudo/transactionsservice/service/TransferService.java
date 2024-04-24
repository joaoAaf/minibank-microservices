package estudo.transactionsservice.service;

import java.util.List;
import java.util.stream.Collectors;

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

    protected List<TransactionView> findByAccount(Long account) {
        var transfers = repo.getTransfersByAccountFrom(account)
                .stream()
                .map(t -> {
                    t.setValue(t.getValue().negate());
                    return toDto(t, Operation.transferSend);
                })
                .collect(Collectors.toList());
        transfers.addAll(repo.getTransfersByAccountTo(account)
                .stream()
                .map(t -> toDto(t, Operation.transferReceived))
                .toList());
        return transfers;
    }

}

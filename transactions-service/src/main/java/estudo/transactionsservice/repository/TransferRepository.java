package estudo.transactionsservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import estudo.transactionsservice.model.Transfer;

@Repository
public interface TransferRepository extends MongoRepository<Transfer, String> {

    List<Transfer> getTransfersByAccountFrom(Long account);
    
}

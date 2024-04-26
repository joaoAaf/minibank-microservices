package estudo.transactionsservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import estudo.transactionsservice.model.Transfer;

@Repository
public interface TransferRepository extends MongoRepository<Transfer, String> {

    @Query("{$or: [{'accountTo': ?0}, {'accountFrom': ?0}]}")
    List<Transfer> getTransfersByAccount(Long account);
    
}

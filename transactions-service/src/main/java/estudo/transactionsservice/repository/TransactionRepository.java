package estudo.transactionsservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import estudo.transactionsservice.model.Transaction;
import estudo.transactionsservice.model.Transfer;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transfer> getTransactionsByAccount(Long account);

}

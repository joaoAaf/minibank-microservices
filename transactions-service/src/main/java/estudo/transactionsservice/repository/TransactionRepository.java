package estudo.transactionsservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import estudo.transactionsservice.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> getTransactionsByAccount(Long account);

}

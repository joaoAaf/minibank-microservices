package estudo.transactionsservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class AccountStatement {

    private Long account;
    private List<TransactionView> transactions;
    private BigDecimal balance = BigDecimal.ZERO;
    
    public void calculateBalance() {
        transactions.forEach(t -> this.balance.add(t.value()));
    }

}

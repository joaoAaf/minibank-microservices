package estudo.transactionsservice.service;

import java.util.Objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import estudo.transactionsservice.request.AccountRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Scope("singleton")
@Service
public class AccountValidationService {

    private final AccountRequest request;

    public boolean validateAccount(Long account) {
        var response = request.getUserAccount(account);  
        if (Objects.isNull(response.data())) {
            throw new RuntimeException(response.msg());
        }
        return true;
    }

}

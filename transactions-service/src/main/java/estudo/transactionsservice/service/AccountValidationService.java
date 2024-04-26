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

    public Object validateAccount(Long ...accounts) {
        for (var account : accounts) {
            var response = request.getUserAccount(account);
            if (Objects.isNull(response.data())) {
                return response.msg();
            }
        }
        return true;
    }

}

package estudo.transactionsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.transactionsservice.dto.TransactionRequest;
import estudo.transactionsservice.service.AccountValidationService;
import estudo.transactionsservice.service.TransactionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("transaction")
public class TransactionController extends BaseController {

    private final TransactionService service;
    private final AccountValidationService validation;

    @PostMapping
    public ResponseEntity<Object> postTransaction(@RequestBody TransactionRequest transactionRequest) {
        try {
            var isValid = validation.validateAccount(transactionRequest.account());
            if (isValid instanceof Boolean && (Boolean) isValid) {
                var transaction = service.save(transactionRequest);
                String msg = String.format("Operação %s registrada com sucesso",
                        transactionRequest.operation().toString());
                return getResponse(transaction, msg, HttpStatus.CREATED);
            }
            return getResponse((String) isValid, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{account}")
    public ResponseEntity<Object> getStatement(@PathVariable Long account) {
        try {
            var isValid = validation.validateAccount(account);
            if (isValid instanceof Boolean && (Boolean) isValid) {
                return getResponse(service.accountStatement(account), HttpStatus.OK);
            }
            return getResponse((String) isValid, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

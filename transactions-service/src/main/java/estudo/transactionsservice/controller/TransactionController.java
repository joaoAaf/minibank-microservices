package estudo.transactionsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            validation.validateAccount(transactionRequest.account());
            var transaction = service.save(transactionRequest);
            String msg = String.format("Operação %s registrada com sucesso", 
                transactionRequest.operation().toString());
            return getResponse(transaction, msg, HttpStatus.CREATED);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

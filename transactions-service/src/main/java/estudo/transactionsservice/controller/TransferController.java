package estudo.transactionsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.transactionsservice.dto.TransferRequest;
import estudo.transactionsservice.service.AccountValidationService;
import estudo.transactionsservice.service.TransactionService;
import estudo.transactionsservice.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("transfer")
@RestController
public class TransferController extends BaseController {

    private final TransactionService transactionService;
    private final AccountValidationService validation;
    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<Object> postTransfer(@RequestBody @Valid TransferRequest request) {
        try {
            if (request.accountFrom().equals(request.accountTo())) {
                return getResponse("Conta de origem e destino não podem ser iguais", HttpStatus.BAD_REQUEST);
            }
            var isValid = validation.validateAccount(request.accountFrom(), request.accountTo());
            if (isValid instanceof Boolean && (Boolean) isValid) {
                var balance = transactionService.accountStatement(request.accountFrom()).getBalance();
                if (balance.compareTo(request.value()) < 0) {
                    return getResponse("Saldo insuficiente", HttpStatus.BAD_REQUEST);
                }
                return getResponse(transferService.save(request), HttpStatus.OK);
            }
            return getResponse((String) isValid, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

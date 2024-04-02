package estudo.transactionsservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.transactionsservice.dto.TransactionRequest;

@RestController
@RequestMapping("transaction")
public class TransactionController extends BaseController {

    @PostMapping
    public ResponseEntity<Object> postTransaction(@RequestBody TransactionRequest transactionRequest) {
        try {
            // TODO: verificar se a conta é válida
            String msg = String.format("Operação %s registrada com sucesso", 
                transactionRequest.operation().toString());
            return getResponse(null, msg, HttpStatus.CREATED);
        } catch (Exception e) {
            return getResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

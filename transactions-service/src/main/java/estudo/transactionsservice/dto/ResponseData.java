package estudo.transactionsservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
// Se um atributo for nulo, o mesmo será excluido do Json
@JsonInclude(value = Include.NON_NULL)
public class ResponseData {

        private Object data;
        private String msg;
        private String port;

}
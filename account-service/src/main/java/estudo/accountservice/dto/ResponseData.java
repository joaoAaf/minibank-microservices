package estudo.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseData {

        private Object data;
        // Se for nulo, o mesmo será excluido do Json
        @JsonInclude(value = Include.NON_NULL)
        private String msg;
        private String port;

}
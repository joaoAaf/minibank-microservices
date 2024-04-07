package estudo.transactionsservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;

@Builder
// Se um atributo for nulo, o mesmo será excluido do Json
@JsonInclude(value = Include.NON_NULL)
public record ResponseData(Object data, String msg, String port) {

}
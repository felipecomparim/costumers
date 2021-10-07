package br.com.fcc.tech.costumers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class ClienteResponseDTO extends ClienteDTO {
    private Integer idade;

}

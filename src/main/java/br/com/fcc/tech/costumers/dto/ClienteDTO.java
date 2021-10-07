package br.com.fcc.tech.costumers.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {
    
	@JsonProperty(access = Access.READ_ONLY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String cep;
    private String cidade;
    private String estado;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;

}

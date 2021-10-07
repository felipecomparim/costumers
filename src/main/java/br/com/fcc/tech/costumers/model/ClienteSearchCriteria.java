package br.com.fcc.tech.costumers.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
@AllArgsConstructor
public class ClienteSearchCriteria {

    private String nome;
    private String cpf;
    private String cidade;
    private String estado;
    private Integer idadeMinima;
    private Integer idadeMaxima;
    
    public LocalDate getDataNascimentoUpperLimit() {
    	return idadeMinima==null?null:LocalDate.now().minusYears(idadeMinima);
    }

    public LocalDate getDataNascimentoLowerLimit() {
    	return idadeMaxima==null?null:LocalDate.now().minusYears(idadeMaxima);
    }
}

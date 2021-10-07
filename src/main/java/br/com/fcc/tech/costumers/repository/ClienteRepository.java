package br.com.fcc.tech.costumers.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.fcc.tech.costumers.model.Cliente;
import br.com.fcc.tech.costumers.model.ClienteSearchCriteria;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>  {
	Page<Cliente> findByNomeContains(String name,Pageable pageable);
	
	@Query(value =  " FROM Cliente c WHERE  " +
			 "(:#{#criteria.nome} is NULL OR lower(c.nome) LIKE concat('%', lower(cast(:#{#criteria.nome} as text)), '%')) "+
			 " AND (:#{#criteria.cpf} is NULL OR lower(c.cpf) LIKE concat('%', lower(cast(:#{#criteria.cpf} as text)), '%')) "+
			 " AND (:#{#criteria.cidade} is NULL OR lower(c.cidade) LIKE concat('%', lower(cast(:#{#criteria.cidade} as text)), '%')) "+
			 " AND (:#{#criteria.estado} is NULL OR lower(c.estado) LIKE concat('%', lower(cast(:#{#criteria.estado} as text)), '%')) "+
			 " AND (:#{#criteria.dataNascimentoUpperLimit} is NULL OR c.dataNascimento <=  :#{#criteria.dataNascimentoUpperLimit} ) " +
			 " AND (:#{#criteria.dataNascimentoLowerLimit} is NULL OR c.dataNascimento >=  :#{#criteria.dataNascimentoLowerLimit} ) " 
			,countQuery="select count(*) from Cliente c WHERE "+
			"(:#{#criteria.nome} is NULL OR lower(c.nome) LIKE concat('%', lower(cast(:#{#criteria.nome} as text)), '%')) "+
			 " AND (:#{#criteria.cpf} is NULL OR lower(c.cpf) LIKE concat('%', lower(cast(:#{#criteria.cpf} as text)), '%')) "+
			 " AND (:#{#criteria.cidade} is NULL OR lower(c.cidade) LIKE concat('%', lower(cast(:#{#criteria.cidade} as text)), '%')) "+
			 " AND (:#{#criteria.estado} is NULL OR lower(c.estado) LIKE concat('%', lower(cast(:#{#criteria.estado} as text)), '%')) "+
			 " AND (:#{#criteria.dataNascimentoUpperLimit} is NULL OR c.dataNascimento <=  :#{#criteria.dataNascimentoUpperLimit} ) " +
			 " AND (:#{#criteria.dataNascimentoLowerLimit} is NULL OR c.dataNascimento >=  :#{#criteria.dataNascimentoLowerLimit} ) " 
			)
	Page<Cliente> findByCriteria(ClienteSearchCriteria criteria,Pageable page);
	
}

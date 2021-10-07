package br.com.fcc.tech.costumers.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fcc.tech.costumers.model.Cliente;
import br.com.fcc.tech.costumers.model.ClienteSearchCriteria;
import br.com.fcc.tech.costumers.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(Pageable pageable) {
    	Page<Cliente> clientes = clienteRepository.findAll(pageable);
    	return clientes.getContent();
    }
        
    public Optional<Cliente> findById(Long id) {
    	return clienteRepository.findById(id);
    }

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public List<Cliente> findByCriteria(ClienteSearchCriteria criteria,Pageable pageable) {
		return clienteRepository.findByCriteria(criteria,pageable).getContent();
	}


}

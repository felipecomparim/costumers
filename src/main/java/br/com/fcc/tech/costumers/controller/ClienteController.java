package br.com.fcc.tech.costumers.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import br.com.fcc.tech.costumers.dto.ClienteDTO;
import br.com.fcc.tech.costumers.dto.ClienteResponseDTO;
import br.com.fcc.tech.costumers.exception.ResourceNotFoundException;
import br.com.fcc.tech.costumers.model.Cliente;
import br.com.fcc.tech.costumers.model.ClienteSearchCriteria;
import br.com.fcc.tech.costumers.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "Costumers - Endpoint de Clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ModelMapper modelMapper;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Página desejada"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Número de registros por página.") })
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteResponseDTO>> findAll(@NotNull @ApiIgnore final Pageable pageable) {
		
		List<Cliente> clientes = clienteService.findAll(pageable);
		if (clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		List<ClienteResponseDTO> clienteResponseDTOs = clientes.stream().map(cliente -> convertToResponseDTO(cliente)).collect(Collectors.toList());
		clienteResponseDTOs.sort(( a,  b) -> a.getIdade() - b.getIdade() );
		
		return new ResponseEntity<>(clienteResponseDTOs,HttpStatus.OK);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteResponseDTO> findById(@PathVariable("id") Long id) {
		
		Optional<Cliente> cliente = clienteService.findById(id);
		if (!cliente.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ClienteResponseDTO clienteResponseDTO = convertToResponseDTO(cliente.get());
		
		return new ResponseEntity<>(clienteResponseDTO,HttpStatus.OK);
	}

	@PostMapping("/clientes")
	public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = convertToEntity(clienteDTO);
		Cliente novoCliente = clienteService.save(cliente);
		
		return new ResponseEntity<>(convertToResponseDTO(novoCliente), HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable("id") Long id, 
													@RequestBody ClienteDTO clienteDTO) {
		
		clienteService
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Cliente [id=" + id + "] não encontrado"));
		Cliente updatedCliente = convertToEntity(clienteDTO);
		updatedCliente.setId(id);
		clienteService.save(updatedCliente);
		
		return new ResponseEntity<>(convertToResponseDTO(updatedCliente), HttpStatus.OK);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable("id") Long id) {
		
		Cliente cliente = clienteService
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente [id=" + id + "] não encontrado"));
		clienteService.delete(cliente);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping("/clientes/findByCriteria")
	@ApiOperation(value = "Busca clientes por diversos critérios", notes="São combinatórios")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "nome", dataType = "String", paramType = "query", value = "Busca clientes por nome "),
		@ApiImplicitParam(name = "cpf", dataType = "String", paramType = "query", value = "Busca clientes por CPF"),
		@ApiImplicitParam(name = "cidade", dataType = "String", paramType = "query", value = "Busca clientes por cidade"), 
		@ApiImplicitParam(name = "estado", dataType = "String", paramType = "query", value = "Busca clientes por estado"), 
		@ApiImplicitParam(name = "idadeMinima", dataType = "integer", paramType = "query", value = "Idade mínima dos clientes buscados"), 
		@ApiImplicitParam(name = "idadeMaxima", dataType = "integer", paramType = "query", value = "Idade máxima dos clientes buscados") 
	})
	@ResponseBody
	public ResponseEntity<List<ClienteDTO>> findClienteByCriteria(  @NotNull @ApiIgnore final Pageable pageable,
																@RequestParam(value = "nome", required = false) String nome,
																@RequestParam(value = "cpf", required = false) String cpf,
																@RequestParam(value = "cidade", required = false) String cidade,
																@RequestParam(value = "estado", required = false) String estado,
																@RequestParam(value = "idadeMinima", required = false) Integer idadeMinima,
																@RequestParam(value = "idadeMaxima", required = false) Integer idadeMaxima)  {
		
		ClienteSearchCriteria criteria = new ClienteSearchCriteria(nome,cpf,cidade,estado,idadeMinima,idadeMaxima);
		List<Cliente> clientes = clienteService.findByCriteria(criteria, pageable);
		if (clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(
				clientes.stream().map(cliente -> convertToResponseDTO(cliente)).collect(Collectors.toList()),
				HttpStatus.OK);
	}

	private Cliente convertToEntity(ClienteDTO clienteDTO) {
		Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
		return cliente;
	}
	
	private ClienteResponseDTO convertToResponseDTO(Cliente cliente) {
		ClienteResponseDTO clienteResponseDTO = modelMapper.map(cliente, ClienteResponseDTO.class);
		clienteResponseDTO
				.setIdade(Integer.valueOf(LocalDate.now().minusYears(cliente.getDataNascimento().getYear()).getYear()));
		return clienteResponseDTO;
	}

}

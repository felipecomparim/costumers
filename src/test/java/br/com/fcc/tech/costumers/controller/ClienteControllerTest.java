package br.com.fcc.tech.costumers.controller;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fcc.tech.costumers.model.Cliente;
import br.com.fcc.tech.costumers.model.ClienteSearchCriteria;
import br.com.fcc.tech.costumers.service.ClienteService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
    	ClienteService clienteService;
	
	Cliente c1 = new Cliente(1l,"Ricardo Alves","123-123-123.00", null, null, null, null, null, LocalDate.of(2001, 7, 12));
	Cliente c2 = new Cliente(2l,"Ivan Lemos","123-123-123.00", null, null, null, null, null, LocalDate.of(1983, 11, 9));
	Cliente c3 = new Cliente(3l,"Marina Gomes","123-123-123.00", null, null, null, null, null, LocalDate.of(1995, 6, 10));
	
	@Test
	public void getAllClientes_success() throws Exception {
	    List<Cliente> clientes = new ArrayList<>(Arrays.asList(c1,c2,c3));
	    Mockito.when(clienteService.findAll(Mockito.any(PageRequest.class))).thenReturn(clientes);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/clientes")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(3)))
	            .andExpect(jsonPath("$[0].idade", is(20)));
	}
	
	@Test
	public void getAllClientes_noContent() throws Exception {
	    List<Cliente> clientes = new ArrayList<>();
	    Mockito.when(clienteService.findAll(Mockito.any(PageRequest.class))).thenReturn(clientes);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/clientes")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
	@Test
	public void getClienteById_success() throws Exception {
	    Mockito.when(clienteService.findById(Mockito.any(Long.class))).thenReturn(Optional.of(c3));
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/clientes/3")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.nome", is("Marina Gomes")));
	}
	
	@Test
	public void getClienteById_noContent() throws Exception {
	    Mockito.when(clienteService.findById(Mockito.any(Long.class))).thenReturn(Optional.empty());
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/clientes/5")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
	@Test
	public void updateClienteRecord_success() throws Exception {
	    Cliente c1_ = new Cliente(1l, "Ricardo Alves[1]", "883.457.289-01", null, null, null, null, null, LocalDate.of(2005, 7, 12));
	           
	    Mockito.when(clienteService.findById(c1_.getId())).thenReturn(Optional.of(c1));
	    Mockito.when(clienteService.save(c1_)).thenReturn(c1_);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/v1/clientes/1")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(c1_));

	    mockMvc.perform(mockRequest)
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.nome", is("Ricardo Alves[1]")));
	}
	// inserido ipad codigo
	
	@Test
	public void deleteClienteById_success() throws Exception {
	    Mockito.when(clienteService.findById(c1.getId())).thenReturn(Optional.of(c1));

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/api/v1/clientes/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void findClientesByCriteria_success() throws Exception {
	    List<Cliente> clientesComIdadeMaxima21 = new ArrayList<>(Arrays.asList(c1));
	    Mockito.when(clienteService.findByCriteria(Mockito.any(ClienteSearchCriteria.class),Mockito.any(PageRequest.class))).thenReturn(clientesComIdadeMaxima21);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/v1/clientes/findByCriteria?idadeMaxima=21")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(1)));
	}

}

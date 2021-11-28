package br.com.fiap.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MunicipioControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@DisplayName("Deve listar todas os municipios e retornar o status 200")
	public void shouldListAllcategories() throws Exception {
		
		mvc.perform(get("/municipio")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	@DisplayName("Deve retornar um municipio pelo ID e com status 200")
	public void shouldFindCategoryById() throws Exception {
		
		mvc.perform(get("/municipio/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("{\"idMunicipio\":1,\"nomeMunicipio\":\"Municipio 1\"}"));
	}

	@Test
	@DisplayName("Deve salvar um municipio, retornar status 201 e Location no Header")
	public void shouldSaveCategory() throws Exception {
		
		mvc.perform(post("/municipio")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"nomeMunicipio\": \"Municipio Novo 1\"}"))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"));
	}
	
	@Test
	@DisplayName("Deve atualizar um municipio pelo id e retornar status 200")
	public void shouldUpdateCategory() throws Exception {
		
		mvc.perform(put("/municipio/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nomeMunicipio\": \"Municipio Alterado\"}"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deve deletar um municipio pelo id e retornar status 204")
	public void shouldDeleteCategoryById() throws Exception {
		
		mvc.perform(delete("/municipio/3")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
}

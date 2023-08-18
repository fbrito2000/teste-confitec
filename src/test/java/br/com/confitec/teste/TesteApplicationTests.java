package br.com.confitec.teste;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.confitec.endpoint.OpcoesPagamentoController;
import br.com.confitec.usecase.GerarOpcoesDePagamento;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@WebMvcTest(OpcoesPagamentoController.class)
class TesteApplicationTests {

	private static final String ENDPOINT = "/confitec/teste/parcelamento";

	@Autowired
   		private MockMvc mvc;
	
	@MockBean
    private GerarOpcoesDePagamento gerarOpcoesDePagamento;

	@Test
    void validarEndpointParcelamentoStatusOK() throws Exception {
        // given
        final String request = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/ApoliceVM.json")));
        // when
        this.mvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(request))
                .andExpect(MockMvcResultMatchers.status().isOk()); //considerando isOK() como 'then'

    }
}

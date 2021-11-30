package br.com.projetosapi.apisjavaspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.projetosapi.apisjavaspring.models.Atividade;
import br.com.projetosapi.apisjavaspring.repositories.AtividadeRepository;

@SpringBootTest
@DataJpaTest
class ApisJavaSpringApplicationTests {

	@Autowired
	private AtividadeRepository repositorio;
	private Atividade atividade;
	
	
	@Test
	public void testSaveAtividade() {
		atividade = new Atividade("Learn how to make a website", "education", 1, 0.1, "", "9924423", 0, "");

		repositorio.save(atividade);
		List<Atividade> lista = (List<Atividade>) repositorio.findAll();
		assertEquals("Learn how to make a website", lista.get(0).getNome());
	}

}

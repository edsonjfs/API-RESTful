package br.com.projetosapi.apisjavaspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.projetosapi.apisjavaspring.models.Atividade;
import br.com.projetosapi.apisjavaspring.repositories.AtividadeRepository;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

	@Autowired
	private AtividadeRepository atividadeRepository;

	@GetMapping
	private Atividade getTeste() {
		try {
			String uri = "https://www.boredapi.com/api/activity";
			RestTemplate restTemplate = new RestTemplate();
			Atividade result = restTemplate.getForObject(uri, Atividade.class);
			return result;
		} catch (RestClientException e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping
	public Atividade novaAtividade() {
		try {
			String uri = "https://www.boredapi.com/api/activity";
			RestTemplate restTemplate = new RestTemplate();
			Atividade result = restTemplate.getForObject(uri, Atividade.class);
			atividadeRepository.save(result);
			return result;
		} catch (RestClientException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/todas-atividades")
	public Iterable<Atividade> obterAtvidades() {
		return atividadeRepository.findAll();
	}

	@GetMapping(value = "/por-parte-do-nome")
	public ResponseEntity<Iterable<Atividade>> obterAtvidadesPorParteDoNome(@RequestParam String parteNome) {

		Iterable<Atividade> atividade = atividadeRepository.findByNomeContaining(parteNome);

		if (atividade.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(atividade);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/pelas-primeiras-letras")
	public ResponseEntity<Iterable<Atividade>> obterAtvidadesPrimeiraLetra(@RequestParam String primeirasLetras) {

		Iterable<Atividade> atividade = atividadeRepository.findByNomeStartingWith(primeirasLetras);

		if (atividade.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(atividade);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/por-id/{id}")
	public ResponseEntity<Atividade> obterAtvidadePorId(@PathVariable int id) {

		Atividade atividade = atividadeRepository.findById(id);

		if (atividade == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(atividade);
		}
	}
	
	@DeleteMapping(value = "/deletar-por-id/{id}")
	public ResponseEntity<Atividade> deletarAtividadePorId(@PathVariable int id){
		
		Atividade atividade = atividadeRepository.findById(id);
		
		if(atividade == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			atividadeRepository.delete(atividade);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	
		
		
	}
}

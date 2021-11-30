package br.com.projetosapi.apisjavaspring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.projetosapi.apisjavaspring.models.Atividade;

public interface AtividadeRepository extends PagingAndSortingRepository<Atividade, Integer>{
	
	public Iterable<Atividade> findByNomeContaining(String parteNome);
	
	public Iterable<Atividade> findByNomeStartingWith(String primeiraLetra);
	
	public Atividade findById(int id);
}

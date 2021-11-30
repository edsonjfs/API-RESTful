package br.com.projetosapi.apisjavaspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Atividade {
	@JsonProperty("activity")
	String nome;
	
	@JsonProperty("type")
	String tipo;
	
	@JsonProperty("participants")
	int participantes;
	
	@JsonProperty("price")
	double preco;
	
	@JsonProperty("link")
	String linkTeste;
	
	@JsonProperty("key")
	String chave;
	
	@JsonProperty("accessibility")
	int acessibildiade;
	
	String atividadeAtributosJson;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	public Atividade() {

	}

	public Atividade(String nome, String tipo, int participantes, double preco, String linkTeste, String chave,
			int acessibildiade, String atividadeAtributosJson) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.participantes = participantes;
		this.preco = preco;
		this.linkTeste = linkTeste;
		this.chave = chave;
		this.acessibildiade = acessibildiade;
		this.atividadeAtributosJson = atividadeAtributosJson;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getLinkTeste() {
		return linkTeste;
	}

	public void setLinkTeste(String linkTeste) {
		this.linkTeste = linkTeste;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public int getAcessibildiade() {
		return acessibildiade;
	}

	public void setAcessibildiade(int acessibildiade) {
		this.acessibildiade = acessibildiade;
	}

	public String getAtividadeAtributosJson() {
		return atividadeAtributosJson;
	}

	public void setAtividadeAtributosJson(String atividadeAtributosJson) {
		this.atividadeAtributosJson = atividadeAtributosJson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Atividade [nome=" + nome + ", tipo=" + tipo + ", participantes=" + participantes + ", preco=" + preco
				+ ", linkTeste=" + linkTeste + ", chave=" + chave + ", acessibildiade=" + acessibildiade
				+ ", atividadeAtributosJson=" + atividadeAtributosJson + ", id=" + id + "]";
	}

}

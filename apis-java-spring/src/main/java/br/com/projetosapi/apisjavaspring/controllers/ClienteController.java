package br.com.projetosapi.apisjavaspring.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.projetosapi.apisjavaspring.models.Atividade;

@RestController
public class ClienteController {

	

	private double calculatePrice(Atividade activity) {
		System.out.println(activity.getPreco());
		return activity.getPreco();
	}

}

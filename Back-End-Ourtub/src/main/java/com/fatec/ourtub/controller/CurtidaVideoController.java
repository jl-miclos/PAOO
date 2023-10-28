package com.fatec.ourtub.controller;

import com.fatec.ourtub.model.CurtidaVideo;
import com.fatec.ourtub.repository.CurtidaVideoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curtidavideo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CurtidaVideoController {

	@Autowired
	private CurtidaVideoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CurtidaVideo>> GetAll(){ // metodo Read GetAll pega todos elementos da tabela para leitura
		return ResponseEntity.ok(repository.findAll());
	}
	
		// não possui GetById pois o numero de curtidas do video é um relacionamento 

	@PostMapping
	public ResponseEntity<CurtidaVideo> post(@RequestBody CurtidaVideo curtidaVideo){ // metodo Create post adiciona elementos uma nova linha na tabela 
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curtidaVideo));
	}

		// Não possui um metodo Update pois o numero de curtidas do vidoe não deve ser alterado 

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){ // metodo Delete delete remove o elemento com o Id na tabela
		repository.deleteById(id);
	}
}

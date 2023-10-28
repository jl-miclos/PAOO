package com.fatec.ourtub.controller;

import com.fatec.ourtub.model.CurtidaComentario;
import com.fatec.ourtub.repository.CurtidaComentarioRepository;

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
@RequestMapping("/curtidacomentario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CurtidaComentarioController {

	@Autowired
	private CurtidaComentarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CurtidaComentario>> GetAll(){ // metodo Read GetAll pega todos elementos da tabela para leitura
		return ResponseEntity.ok(repository.findAll());
	}

		// não possui GetById pois o numero de curtidas do comentario é um relacionamento 

	@PostMapping
	public ResponseEntity<CurtidaComentario> post(@RequestBody CurtidaComentario curtidaComentario){// metodo Create post adiciona elementos uma nova linha na tabela 
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curtidaComentario));
	}

		// Não possui um metodo Update pois o numero de curtidas no comentario não deve ser alterado 

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){// metodo Delete delete remove o elemento com o Id na tabela
		repository.deleteById(id);
	}
}

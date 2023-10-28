package com.fatec.ourtub.controller;

import com.fatec.ourtub.model.Video;
import com.fatec.ourtub.repository.VideoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VideoController {

	@Autowired
	private VideoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Video>> GetAll(){ // metodo Read GetAll pega todos elementos da tabela para leitura   
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Video> GetById(@PathVariable long id){ // metodo Read GetAll pega todos elementos da tabela para leitura  
		return repository.findById(id)
						 .map(resp -> ResponseEntity.ok(resp)) // reposta com todas as colunas da tabela selecionada 
						 .orElse(ResponseEntity.notFound().build()); // resposta de erro caso o Id não seja encontrado na tabela
	}

	@PostMapping
	public ResponseEntity<Video> post(@RequestBody Video video){// metodo Create post adiciona elementos uma nova linha na tabela 
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(video));
	}

	@PutMapping
	public ResponseEntity<Video> put(@RequestBody Video video){// metodo Update put adiciona ou substitu elementos em uma linha da tabela
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(video));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){// metodo Delete delete remove o elemento com o Id na tabela
		repository.deleteById(id);
	}
}

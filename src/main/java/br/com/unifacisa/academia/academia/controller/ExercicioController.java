package br.com.unifacisa.academia.academia.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unifacisa.academia.academia.dto.CriarExercicio;
import br.com.unifacisa.academia.academia.models.Exercicio;
import br.com.unifacisa.academia.academia.services.ExercicioService;
	
@Controller
@RequestMapping("/exercicio")
public class ExercicioController {

	@Autowired
	private ExercicioService service;
	
	@GetMapping
	public ResponseEntity<List<Exercicio>> getAll(){
		return new ResponseEntity<List<Exercicio>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Exercicio> getById(@PathVariable Long id){
		return new ResponseEntity<Exercicio>(service.findOne(id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Exercicio> delete(@PathVariable Long id){
		return new ResponseEntity<Exercicio>(service.delete(id),HttpStatus.OK);
	}
	@PutMapping()
	public ResponseEntity<Exercicio> update( @RequestBody Exercicio exercicio){
		return new ResponseEntity<Exercicio>(service.update(exercicio), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Exercicio> create(@RequestBody CriarExercicio exercicio){
		return new ResponseEntity<Exercicio>(service.insert(exercicio), HttpStatus.CREATED);
	}
	


}

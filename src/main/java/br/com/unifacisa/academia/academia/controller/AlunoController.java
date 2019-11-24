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

import br.com.unifacisa.academia.academia.dto.CriarAluno;
import br.com.unifacisa.academia.academia.dto.HorarioAluno;
import br.com.unifacisa.academia.academia.models.Aluno;
import br.com.unifacisa.academia.academia.services.AlunoService;
import br.com.unifacisa.academia.academia.services.exceptions.NotFoundException;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAll(){
		return new ResponseEntity<List<Aluno>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Aluno> getById(@PathVariable Long id) throws NotFoundException{
		return new ResponseEntity<Aluno>(service.findOne(id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Aluno> delete(@PathVariable Long id) throws NotFoundException{
		return new ResponseEntity<Aluno>(service.delete(id),HttpStatus.OK);
	}
	@PutMapping()
	public ResponseEntity<Aluno> update( @RequestBody Aluno aluno) throws NotFoundException{
		return new ResponseEntity<Aluno>(service.update(aluno), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Aluno> create(@RequestBody CriarAluno aluno){
		return new ResponseEntity<Aluno>(service.insert(aluno), HttpStatus.CREATED);
	}
	
	@GetMapping("/horario/{id}")
	public ResponseEntity<HorarioAluno> getHorarioAluno(@PathVariable Long id) {
		return new ResponseEntity<HorarioAluno>(service.getHorarioAluno(id),HttpStatus.OK);
	}
}

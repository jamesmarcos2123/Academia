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

import br.com.unifacisa.academia.academia.dto.FrequenciaDto;
import br.com.unifacisa.academia.academia.models.Professor;
import br.com.unifacisa.academia.academia.services.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	

		@Autowired
		private ProfessorService service;
		
	
		
		@GetMapping
		public ResponseEntity<List<Professor>> getAll(){
			return new ResponseEntity<List<Professor>>(service.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("{id}")
		public ResponseEntity<Professor> getById(@PathVariable Long id){
			return new ResponseEntity<Professor>(service.findOne(id), HttpStatus.OK);
		}
		
		@DeleteMapping("{id}")
		public ResponseEntity<Professor> delete(@PathVariable Long id){
			return new ResponseEntity<Professor>(service.delete(id),HttpStatus.OK);
		}
		@PutMapping()
		public ResponseEntity<Professor> update( @RequestBody Professor professor){
			return new ResponseEntity<Professor>(service.update(professor), HttpStatus.OK);
		}
		
		
		@PostMapping
		public ResponseEntity<Professor> create(@RequestBody Professor professor){
			return new ResponseEntity<Professor>(service.insert(professor), HttpStatus.CREATED);
		}
		@PutMapping("presenca/{idAluno}/{idExercicio}")
		public ResponseEntity<String> addPresenca(@PathVariable Long idAluno, @PathVariable Long idExercicio){
			service.AddFrequencia(idAluno, idExercicio);
			return new ResponseEntity<String>("Frequencia adcionada com sucesso", HttpStatus.OK);
		}
		@PutMapping("addexercicio/{idAluno}/{idExercicio}")
		public ResponseEntity<String> addExercicio(@PathVariable Long idAluno, @PathVariable Long idExercicio){
			service.addExercicio(idAluno,idExercicio);
			return new ResponseEntity<String>("Exercio adcionado com sucesso", HttpStatus.OK);
		}
		
		@GetMapping("presenca/{idExercicio}")
		public ResponseEntity<FrequenciaDto> getFrequencia(@PathVariable Long idExercicio){
			return new ResponseEntity<FrequenciaDto>(service.getFrequencia(idExercicio),HttpStatus.OK);
		}
		
		

}

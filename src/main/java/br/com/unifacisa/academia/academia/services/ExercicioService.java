package br.com.unifacisa.academia.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.academia.academia.dto.CriarExercicio;
import br.com.unifacisa.academia.academia.models.Exercicio;
import br.com.unifacisa.academia.academia.repository.ExercicioRepository;
import br.com.unifacisa.academia.academia.repository.ProfessorRepository;
import br.com.unifacisa.academia.academia.services.exceptions.NotFoundException;

@Service
public class ExercicioService {

	@Autowired
	private ExercicioRepository repository;
	@Autowired 
	private ProfessorRepository profeRepository;

	public Exercicio insert(CriarExercicio exercicioDto) {
		if(profeRepository.existsById(exercicioDto.getProfessor())) {
		Exercicio exercicio = new Exercicio(exercicioDto.getNome(),exercicioDto.getProfessor(),exercicioDto.getHorarioInicio(),exercicioDto.getHorarioFinal());
		return repository.save(exercicio);
		} else {
			throw new NotFoundException("Professor inexistente");
		}
	}

	public List<Exercicio> findAll() {
		return repository.findAll();
	}

	public Exercicio findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Id: " + id + " Inexistente"));
	}

	public Exercicio delete(Long id) {
		if (repository.existsById(id)) {
			Exercicio aluno = repository.getOne(id);
			repository.deleteById(id);
			return aluno;
		} else {
			throw new NotFoundException("Id: " + id + " Inexistente");
		}

	}

	public Exercicio update(Exercicio exercicio) {
		if (repository.existsById(exercicio.getId())) {
			return repository.save(exercicio);
		} else {
			throw new NotFoundException("Id: " + exercicio.getId() + " Inexistente");
		}
	}

	

}

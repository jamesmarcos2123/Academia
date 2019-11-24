package br.com.unifacisa.academia.academia.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.academia.academia.dto.FrequenciaDto;
import br.com.unifacisa.academia.academia.models.Aluno;
import br.com.unifacisa.academia.academia.models.Exercicio;
import br.com.unifacisa.academia.academia.models.Professor;
import br.com.unifacisa.academia.academia.repository.AlunoRepository;
import br.com.unifacisa.academia.academia.repository.ExercicioRepository;
import br.com.unifacisa.academia.academia.repository.ProfessorRepository;
import br.com.unifacisa.academia.academia.services.exceptions.NotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	@Autowired
	private ExercicioRepository repositoryExerc;
	@Autowired
	private AlunoRepository repositoryAluno;

	public Professor insert(Professor professor) {
		return repository.save(professor);
	}

	public List<Professor> findAll() {
		return repository.findAll();
	}

	public Professor findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Id: " + id + " Inexistente"));
	}

	public Professor delete(Long id) {
		if (repository.existsById(id)) {
			Professor professor = repository.getOne(id);
			repository.deleteById(id);
			return professor;
		} else {
			throw new NotFoundException("Id: " + id + " Inexistente");
		}

	}
	
	public Professor update(Professor professor) {
		if(repository.existsById(professor.getId())) {
			return repository.save(professor);
		} else {
			throw new NotFoundException("Id: " + professor.getId() + " Inexistente");
		}
	}
	
	public void AddFrequencia(Long idAluno, Long idExercicio) {
		if(repositoryAluno.existsById(idAluno) && repositoryExerc.existsById(idExercicio)) {
			Exercicio exercicio = repositoryExerc.getOne(idExercicio);
			if(exercicio.getFrequencia() == null) {
				ArrayList<Long> idsAlunos = new ArrayList<Long>();
				exercicio.getFrequencia().setFrequencia(idsAlunos);
			}
			exercicio.getFrequencia().addId(idAluno);
			exercicio.getFrequencia().setDia(new Date());
			
			repositoryExerc.save(exercicio);
			
		} else {
			throw new NotFoundException("Id Inexistente");

		}
	}
	

	public void addExercicio(Long idAluno, Long idExercicio) {

		if(repositoryAluno.existsById(idAluno)  && repositoryExerc.existsById(idExercicio)) {
			Aluno aluno = repositoryAluno.getOne(idAluno);
			if(aluno.getExercicios() == null) {
				List<Exercicio> exercicios = new ArrayList<Exercicio>();
				aluno.setExercicios(exercicios);
			}
			aluno.AddList(repositoryExerc.getOne(idExercicio));
			repositoryAluno.save(aluno);

		} else {
			throw new NotFoundException("Id Inexistente");
		}
	}
	
	public FrequenciaDto getFrequencia(Long idExercicio) {
		if(repositoryExerc.existsById(idExercicio)) {
			Exercicio exercicio = repositoryExerc.getOne(idExercicio);
			FrequenciaDto frequencia = new FrequenciaDto(exercicio.getFrequencia().getFrequencia(), exercicio.getFrequencia().getDia());
			return frequencia;
		}else {
			throw new NotFoundException("Id "+ idExercicio+"Inexistente");
		}
	}


}

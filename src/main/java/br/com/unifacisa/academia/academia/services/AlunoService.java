package br.com.unifacisa.academia.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.academia.academia.dto.CriarAluno;
import br.com.unifacisa.academia.academia.dto.HorarioAluno;
import br.com.unifacisa.academia.academia.models.Aluno;
import br.com.unifacisa.academia.academia.repository.AlunoRepository;
import br.com.unifacisa.academia.academia.services.exceptions.NotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public Aluno insert(CriarAluno aluno) {
		Aluno alunoCriado = new Aluno(aluno.getNome(), aluno.getEndereco(), aluno.getCpf(), null);
		return repository.save(alunoCriado);
	}

	public List<Aluno> findAll() {
		return repository.findAll();
	}

	public Aluno findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Id: " + id + " Inexistente"));
	}

	public Aluno delete(Long id) {
		if (repository.existsById(id)) {
			Aluno aluno = repository.getOne(id);
			repository.deleteById(id);
			return aluno;
		} else {
			throw new NotFoundException("Id: " + id + " Inexistente");
		}

	}

	public Aluno update(Aluno aluno) {
		if (repository.existsById(aluno.getId())) {
			return repository.save(aluno);
		} else {
			throw new NotFoundException("Id: " + aluno.getId() + " Inexistente");
		}
	}

	public HorarioAluno getHorarioAluno(Long id) {
		if (repository.existsById(id)) {
			Aluno aluno = repository.getOne(id);

			HorarioAluno alunodto = new HorarioAluno(aluno.getNome(), aluno.getExercicios());
			return alunodto;
		} else {
			throw new NotFoundException("Id: " + id + " Inexistente");
		}
	}

}

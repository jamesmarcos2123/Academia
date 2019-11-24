package br.com.unifacisa.academia.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacisa.academia.academia.models.Frequencia;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, Long> {

}

package br.com.renan.medicadastro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.renan.medicadastro.modelo.Paciente;


@Repository
@Transactional
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}

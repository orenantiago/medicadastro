package br.com.renan.medicadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.renan.medicadastro.modelo.Exame;

@Repository
@Transactional
public interface ExameRepository extends JpaRepository<Exame, Long>{

}

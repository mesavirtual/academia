package com.mesavirtual.academia.repository;

import com.mesavirtual.academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

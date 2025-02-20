package com.mesavirtual.academia.repository;

import com.mesavirtual.academia.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

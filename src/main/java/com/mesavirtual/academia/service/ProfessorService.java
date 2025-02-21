package com.mesavirtual.academia.service;

import com.mesavirtual.academia.dto.ProfessorDTO;
import com.mesavirtual.academia.model.Professor;
import com.mesavirtual.academia.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorDTO> listarTodos() {
        return professorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO salvarProfessor(ProfessorDTO professorDTO) {
        Professor professor = convertToEntity(professorDTO);
        professor = professorRepository.save(professor);
        return convertToDTO(professor);
    }

    public ProfessorDTO buscarPorId(Long id) {
        return professorRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    private ProfessorDTO convertToDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(professor.getId());
        professorDTO.setNome(professor.getNome());
        professorDTO.setCpf(professor.getCpf());
        professorDTO.setEspecializacao(professor.getEspecializacao());
        if (professor.getUsuario() != null) {
            professorDTO.setUsuarioId(professor.getUsuario().getId());
        }
        return professorDTO;
    }

    private Professor convertToEntity(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setId(professorDTO.getId());
        professor.setNome(professorDTO.getNome());
        professor.setCpf(professorDTO.getCpf());
        professor.setEspecializacao(professorDTO.getEspecializacao());
        return professor;
    }
}
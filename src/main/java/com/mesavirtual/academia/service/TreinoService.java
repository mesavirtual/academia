package com.mesavirtual.academia.service;

import com.mesavirtual.academia.dto.TreinoDTO;
import com.mesavirtual.academia.model.Aluno;
import com.mesavirtual.academia.model.Professor;
import com.mesavirtual.academia.model.Treino;
import com.mesavirtual.academia.repository.AlunoRepository;
import com.mesavirtual.academia.repository.ProfessorRepository;
import com.mesavirtual.academia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<TreinoDTO> listarTodos() {
        return treinoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TreinoDTO salvarTreino(TreinoDTO treinoDTO) {
        Treino treino = convertToEntity(treinoDTO);
        treino = treinoRepository.save(treino);
        return convertToDTO(treino);
    }

    public TreinoDTO buscarPorId(Long id) {
        return treinoRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public void deletarTreino(Long id) {
        treinoRepository.deleteById(id);
    }

    private TreinoDTO convertToDTO(Treino treino) {
        TreinoDTO treinoDTO = new TreinoDTO();
        treinoDTO.setId(treino.getId());
        treinoDTO.setDescricao(treino.getDescricao());
        treinoDTO.setDataInicio(treino.getDataInicio());
        treinoDTO.setDataFim(treino.getDataFim());
        treinoDTO.setAlunoId(treino.getAluno().getId());
        treinoDTO.setProfessorId(treino.getProfessor().getId());
        return treinoDTO;
    }

    private Treino convertToEntity(TreinoDTO treinoDTO) {
        Treino treino = new Treino();
        treino.setId(treinoDTO.getId());
        treino.setDescricao(treinoDTO.getDescricao());
        treino.setDataInicio(treinoDTO.getDataInicio());
        treino.setDataFim(treinoDTO.getDataFim());

        Aluno aluno = alunoRepository.findById(treinoDTO.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        treino.setAluno(aluno);

        Professor professor = professorRepository.findById(treinoDTO.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        treino.setProfessor(professor);

        return treino;
    }
}
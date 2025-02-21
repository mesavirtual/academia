package com.mesavirtual.academia.service;

import com.mesavirtual.academia.dto.AlunoDTO;
import com.mesavirtual.academia.dto.TreinoDTO;
import com.mesavirtual.academia.model.Aluno;
import com.mesavirtual.academia.model.Treino;
import com.mesavirtual.academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoDTO buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    private AlunoDTO convertToDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setCpf(aluno.getCpf());
        alunoDTO.setDataNascimento(aluno.getDataNascimento());
        alunoDTO.setEndereco(aluno.getEndereco());
        alunoDTO.setTelefone(aluno.getTelefone());

        if (aluno.getTreinos() != null) {
            List<TreinoDTO> treinoDTOS = aluno.getTreinos().stream()
                    .map(this::convertTreinoToDTO)
                    .collect(Collectors.toList());
            alunoDTO.setTreinos(treinoDTOS);
        }

        return alunoDTO;
    }

    private TreinoDTO convertTreinoToDTO(Treino treino) {
        TreinoDTO treinoDTO = new TreinoDTO();
        treinoDTO.setId(treino.getId());
        treinoDTO.setDescricao(treino.getDescricao());
        treinoDTO.setDataInicio(treino.getDataInicio());
        treinoDTO.setDataFim(treino.getDataFim());
        return treinoDTO;
    }

}

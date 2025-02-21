package com.mesavirtual.academia.service;

import com.mesavirtual.academia.dto.FichaAcompanhamentoDTO;
import com.mesavirtual.academia.model.FichaAcompanhamento;
import com.mesavirtual.academia.repository.FichaAcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FichaAcompanhamentoService {

    @Autowired
    private FichaAcompanhamentoRepository fichaRepository;

    public List<FichaAcompanhamentoDTO> listarTodos() {
        return fichaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FichaAcompanhamentoDTO salvarFicha(FichaAcompanhamentoDTO fichaDTO) {
        FichaAcompanhamento ficha = convertToEntity(fichaDTO);
        ficha = fichaRepository.save(ficha);
        return convertToDTO(ficha);
    }

    public FichaAcompanhamentoDTO buscarPorId(Long id) {
        return fichaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public void deletarFicha(Long id) {
        fichaRepository.deleteById(id);
    }

    private FichaAcompanhamentoDTO convertToDTO(FichaAcompanhamento ficha) {
        FichaAcompanhamentoDTO fichaDTO = new FichaAcompanhamentoDTO();
        fichaDTO.setId(ficha.getId());
        fichaDTO.setPeso(ficha.getPeso());
        fichaDTO.setAltura(ficha.getAltura());
        fichaDTO.setPercentualGordura(ficha.getPercentualGordura());
        fichaDTO.setDataMedicao(ficha.getDataMedicao());
        fichaDTO.setAlunoId(ficha.getAluno().getId());
        return fichaDTO;
    }

    private FichaAcompanhamento convertToEntity(FichaAcompanhamentoDTO fichaDTO) {
        FichaAcompanhamento ficha = new FichaAcompanhamento();
        ficha.setId(fichaDTO.getId());
        ficha.setPeso(fichaDTO.getPeso());
        ficha.setAltura(fichaDTO.getAltura());
        ficha.setPercentualGordura(fichaDTO.getPercentualGordura());
        ficha.setDataMedicao(fichaDTO.getDataMedicao());
        // Aluno deve ser buscado do banco de dados
        return ficha;
    }
}
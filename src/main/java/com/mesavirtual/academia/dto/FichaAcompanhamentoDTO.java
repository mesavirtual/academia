package com.mesavirtual.academia.dto;

import com.mesavirtual.academia.model.FichaAcompanhamento;

import java.time.LocalDate;

public class FichaAcompanhamentoDTO {
    private Long id;
    private double peso;
    private double altura;
    private double percentualGordura;
    private LocalDate dataMedicao;
    private Long alunoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public LocalDate getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(LocalDate dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
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
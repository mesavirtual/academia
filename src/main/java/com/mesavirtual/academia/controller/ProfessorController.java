package com.mesavirtual.academia.controller;

import com.mesavirtual.academia.dto.ProfessorDTO;
import com.mesavirtual.academia.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorDTO> listarProfessores() {
        return professorService.listarTodos();
    }

    @PostMapping
    public ProfessorDTO criarProfessor(@RequestBody ProfessorDTO professorDTO) {
        return professorService.salvarProfessor(professorDTO);
    }

    @GetMapping("/{id}")
    public ProfessorDTO buscarProfessor(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
    }
}
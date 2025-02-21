package com.mesavirtual.academia.controller;

import com.mesavirtual.academia.dto.FichaAcompanhamentoDTO;
import com.mesavirtual.academia.service.FichaAcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichas")
public class FichaAcompanhamentoController {

    @Autowired
    private FichaAcompanhamentoService fichaService;

    @GetMapping
    public List<FichaAcompanhamentoDTO> listarFichas() {
        return fichaService.listarTodos();
    }

    @PostMapping
    public FichaAcompanhamentoDTO criarFicha(@RequestBody FichaAcompanhamentoDTO fichaDTO) {
        return fichaService.salvarFicha(fichaDTO);
    }

    @GetMapping("/{id}")
    public FichaAcompanhamentoDTO buscarFicha(@PathVariable Long id) {
        return fichaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFicha(@PathVariable Long id) {
        fichaService.deletarFicha(id);
    }
}
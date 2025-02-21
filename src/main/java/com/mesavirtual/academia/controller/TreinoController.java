package com.mesavirtual.academia.controller;

import com.mesavirtual.academia.dto.TreinoDTO;
import com.mesavirtual.academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping
    public List<TreinoDTO> listarTreinos() {
        return treinoService.listarTodos();
    }

    @PostMapping
    public TreinoDTO criarTreino(@RequestBody TreinoDTO treinoDTO) {
        return treinoService.salvarTreino(treinoDTO);
    }

    @GetMapping("/{id}")
    public TreinoDTO buscarTreino(@PathVariable Long id) {
        return treinoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarTreino(@PathVariable Long id) {
        treinoService.deletarTreino(id);
    }
}

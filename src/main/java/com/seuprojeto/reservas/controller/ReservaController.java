package com.seuprojeto.reservas.controller;

import com.seuprojeto.reservas.model.Reserva;
import com.seuprojeto.reservas.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return service.criarReserva(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listarReservas();
    }

    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Reserva atualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        return service.atualizarReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        service.cancelarReserva(id);
    }
}

@Controller
class ReservaViewController {
    @GetMapping("/criar-reserva")
    public String criarReserva() {
        return "formulario";
    }

    @GetMapping("/listar-reservas")
    public String listarReservas() {
        return "reservas";
    }
}
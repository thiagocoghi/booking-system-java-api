package com.seuprojeto.reservas.service;

import com.seuprojeto.reservas.model.Reserva;
import com.seuprojeto.reservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public Reserva criarReserva(Reserva reserva) {
        if (repository.existsByRecursoAndDataInicioAndDataFim(
                reserva.getRecurso(), reserva.getDataInicio(), reserva.getDataFim())) {
            throw new RuntimeException("Recurso já reservado nesse período.");
        }
        return repository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return repository.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada."));
    }

    public Reserva atualizarReserva(Long id, Reserva novaReserva) {
        Reserva existente = buscarPorId(id);
        existente.setCliente(novaReserva.getCliente());
        existente.setRecurso(novaReserva.getRecurso());
        existente.setDataInicio(novaReserva.getDataInicio());
        existente.setDataFim(novaReserva.getDataFim());
        return repository.save(existente);
    }

    public void cancelarReserva(Long id) {
        repository.deleteById(id);
    }
}
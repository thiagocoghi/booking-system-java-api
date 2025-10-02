package com.seuprojeto.reservas.repository;

import com.seuprojeto.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByRecursoAndDataInicioAndDataFim(String recurso, LocalDate dataInicio, LocalDate dataFim);
}
package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DisponibilidadMedica {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoDisponibilidad estado;

    public DisponibilidadMedica(Long id, LocalDate fecha, LocalTime hora, EstadoDisponibilidad estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public EstadoDisponibilidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoDisponibilidad estado) {
        this.estado = estado;
    }
}

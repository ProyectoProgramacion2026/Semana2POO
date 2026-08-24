package model;

public class CitaMedica {
    private Long id;
    private Paciente paciente;
    private DisponibilidadMedica disponibilidad;
    private EstadoCita estado;

    public CitaMedica(Long id, Paciente paciente, DisponibilidadMedica disponibilidad, EstadoCita estado) {
        this.id = id;
        this.paciente = paciente;
        this.disponibilidad = disponibilidad;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DisponibilidadMedica getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(DisponibilidadMedica disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
}

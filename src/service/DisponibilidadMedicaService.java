package service;

import model.DisponibilidadMedica;
import model.EstadoDisponibilidad;
import repository.DisponibilidadMedicaRepository;

import java.util.List;

public class DisponibilidadMedicaService {
    private DisponibilidadMedicaRepository disponibilidadMedicaRepository;

    public DisponibilidadMedicaService(DisponibilidadMedicaRepository disponibilidadMedicaRepository) {
        this.disponibilidadMedicaRepository = disponibilidadMedicaRepository;
    }

    public void registrarDisponibilidadMedica(DisponibilidadMedica disponibilidadMedica) {
        if(disponibilidadMedica.getFecha() == null || disponibilidadMedica.getHora() == null) {
            System.out.println("Se debe registrar fecha y hora de la cita");
            return;
        }

        for(DisponibilidadMedica dm : disponibilidadMedicaRepository.getDisponibilidadMedicas()){
            if(dm.getFecha().equals(disponibilidadMedica.getFecha()) &&  dm.getHora().equals(disponibilidadMedica.getHora())){
                System.out.println("Ya existe una disponibilidad para esa fecha y hora");
                return;
            }
        }

        disponibilidadMedica.setEstado(EstadoDisponibilidad.DISPONIBLE);

        disponibilidadMedicaRepository.guardar(disponibilidadMedica);
        System.out.println("Disponibilidad medica registrado exitosamente");
    }

    public List<DisponibilidadMedica> getDisponibilidadMedicas() {
        return disponibilidadMedicaRepository.getDisponibilidadMedicas();
    }
}

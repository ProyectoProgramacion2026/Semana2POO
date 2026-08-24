package repository;

import model.DisponibilidadMedica;

import java.util.List;

public class DisponibilidadMedicaRepository {
    List<DisponibilidadMedica> disponibilidadMedicas;

    public void guardar(DisponibilidadMedica disponibilidadMedica) {
        disponibilidadMedicas.add(disponibilidadMedica);
    }

    public List<DisponibilidadMedica> getDisponibilidadMedicas() {
        return disponibilidadMedicas;
    }
}

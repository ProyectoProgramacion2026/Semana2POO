package repository;

import model.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {
    private List<Medico> medicos = new ArrayList<>();

    public void guardarMedico(Medico medico) {
        medicos.add(medico);
    }

    public Medico buscarMedicoPorId(Long id) {
        for (Medico medico : medicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
}

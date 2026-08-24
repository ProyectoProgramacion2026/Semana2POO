package service;

import model.Medico;
import repository.MedicoRepository;

import java.util.List;

public class MedicoService {

    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void registrarMedico(Medico medico) {

        // Validar correo
        if (!ValidarService.validarEmail(medico.getEmail())) {
            System.out.println("Correo inválido");
            return;
        }

        // Validar que el correo no exista
        for (Medico m : medicoRepository.getMedicos()) {
            if (m.getEmail() != null &&
                    m.getEmail().equalsIgnoreCase(medico.getEmail())) {

                System.out.println("El correo ya está registrado");
                return;
            }
        }

        medicoRepository.guardarMedico(medico);
        System.out.println("Médico registrado correctamente");
    }

    public Medico getMedico(Long id) {
        Medico medico = medicoRepository.buscarMedicoPorId(id);
        if(medico == null) {
            System.out.println("Medico no encontrado");
            return null;
        }
        return medico;
    }

    public List<Medico> getMedicos() {
        return medicoRepository.getMedicos();
    }
}
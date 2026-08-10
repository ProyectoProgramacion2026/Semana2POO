package service;

import model.Paciente;
import repository.PacienteRepository;

import java.util.List;

public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void registrarPaciente(Paciente paciente) {
        pacienteRepository.guardar(paciente);
        System.out.println("Paciente registrado");
    }

    public List<Paciente> getPacientes() {
        return pacienteRepository.getPacientes();
    }

    public boolean login(String email, String password) {
        for(Paciente paciente : pacienteRepository.getPacientes()){
            if(paciente.getEmail().equals(email) && paciente.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

package service;

import model.Paciente;
import repository.PacienteRepository;

import java.util.List;
import java.util.regex.Pattern;

public class PacienteService {

    private PacienteRepository pacienteRepository;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void registrarPaciente(Paciente paciente) {

        //Validar que el correo sea obligatorio
        if(paciente.getEmail() == null || paciente.getEmail().trim().isEmpty()){
            System.out.println("El correo es obligatorio");
            return;
        }

        //Validar el formato correcto de correo
        if (!EMAIL_PATTERN.matcher(paciente.getEmail()).matches()) {
            System.out.println("Formato de correo inválido");
            return;
        }

        //Validar que la contraseña sea obligatoria
        if (paciente.getPassword() == null || paciente.getPassword().trim().isEmpty()) {
            System.out.println("La contraseña es obligatoria");
            return;
        }

        //Validar que el correo no exista
        for (Paciente p : pacienteRepository.getPacientes()) {
            if (p.getEmail().equalsIgnoreCase(paciente.getEmail())) {
                System.out.println("El correo ya está registrado");
                return;
            }
        }

        pacienteRepository.guardar(paciente);
        System.out.println("Paciente registrado correctamente");
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

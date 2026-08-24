package service;

import model.Paciente;
import repository.PacienteRepository;

import java.util.List;
import java.util.regex.Pattern;

public class PacienteService {

    private PacienteRepository pacienteRepository;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$");

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    private boolean validarCorreo(String correo) {
        return EMAIL_PATTERN.matcher(correo).matches();
    }

    public void registrarPaciente(Paciente paciente) {

        // Validar que el correo sea obligatorio
        if (paciente.getEmail() == null || paciente.getEmail().trim().isEmpty()) {
            System.out.println("El correo es obligatorio");
            return;
        }

        // Validar formato del correo
        if (!validarCorreo(paciente.getEmail())) {
            System.out.println("Formato de correo inválido");
            return;
        }

        // Validar que la contraseña sea obligatoria
        if (paciente.getPassword() == null || paciente.getPassword().trim().isEmpty()) {
            System.out.println("La contraseña es obligatoria");
            return;
        }

        // Validar que el correo no exista
        for (Paciente p : pacienteRepository.getPacientes()) {
            if (p.getEmail() != null &&
                    p.getEmail().equalsIgnoreCase(paciente.getEmail())) {

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

    public String login(String email, String password) {

        // Validar que el correo no esté vacío
        if (email == null || email.trim().isEmpty()) {
            return "Debe ingresar un correo";
        }

        // Validar que la contraseña no esté vacía
        if (password == null || password.trim().isEmpty()) {
            return "Debe ingresar una contraseña";
        }

        // Validar formato del correo
        if (!validarCorreo(email)) {
            return "Formato de correo inválido";
        }

        // Buscar el correo registrado
        for (Paciente paciente : pacienteRepository.getPacientes()) {

            if (paciente.getEmail() != null &&
                    paciente.getEmail().equalsIgnoreCase(email)) {

                // Validar contraseña
                if (paciente.getPassword().equals(password)) {
                    return "Login exitoso";
                } else {
                    return "Correo o contraseña incorrectos";
                }
            }
        }

        return "El correo no está registrado";
    }
}
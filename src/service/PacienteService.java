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

        // Validar correo
        if (!ValidarService.validarEmail(paciente.getEmail())) {
            System.out.println("Correo inválido");
            return;
        }

        // Validar contraseña
        if (!ValidarService.validarPassword(paciente.getPassword())) {
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

        String passwordEncriptado = PasswordService.encriptar(paciente.getPassword());
        paciente.setPassword(passwordEncriptado);

        pacienteRepository.guardar(paciente);
        System.out.println("Paciente registrado correctamente");
    }

    public List<Paciente> getPacientes() {
        return pacienteRepository.getPacientes();
    }

    public String login(String email, String password) {

        // Validar correo
        if (!ValidarService.validarEmail(email)) {
            return "Correo inválido";
        }

        // Validar contraseña
        if (!ValidarService.validarPassword(password)) {
            return "Debe ingresar una contraseña";
        }

        // Buscar el usuario
        for (Paciente paciente : pacienteRepository.getPacientes()) {

            if (paciente.getEmail() != null &&
                    paciente.getEmail().equalsIgnoreCase(email)) {

                if (PasswordService.checkPassword(password, paciente.getPassword())) {
                    return "Login exitoso";
                }

                return "Correo o contraseña incorrectos";
            }
        }

        return "El correo no está registrado";
    }
}
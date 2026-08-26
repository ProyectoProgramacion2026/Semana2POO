import model.Paciente;
import repository.PacienteRepository;
import service.PacienteService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PacienteRepository pacienteRepository = new PacienteRepository();
        PacienteService pacienteService = new PacienteService(pacienteRepository);
        Paciente paciente1 = new Paciente(123L, "Carlos", "carlos@mail.com", "abc123");
        Paciente paciente2 = new Paciente(123L, "Carlos", "carlos@mail.com", "abc123");
        pacienteService.registrarPaciente(paciente1);
        pacienteService.registrarPaciente(paciente2);

        //Sin toString

        List<Paciente> pacientes = pacienteService.getPacientes();
        for(Paciente paciente : pacientes){
            System.out.println(paciente);
        }

        //índice
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(pacientes.get(i));
        }

        //if
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
        } else {
            System.out.println("Pacientes encontrados:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }

        //login exitoso
        System.out.println(pacienteService.login("carlos@mail.com", "abc123"));
        //login incorrecto
        System.out.println(pacienteService.login("carlos@mail.com", "abc1234"));

    }
}
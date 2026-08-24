package service;

import java.util.regex.Pattern;

public class ValidarService {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$");

    private static final Pattern TELEFONO_PATTERN =
            Pattern.compile("^(\\d{3}-\\d{3}-\\d{4})$");

    public static boolean validarEmail(String email) {
        return email != null
                && !email.trim().isEmpty()
                && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean validarPassword(String password) {
        return password != null
                && !password.trim().isEmpty();
    }

    public static boolean validarTelefono(String telefono) {
        return telefono != null
                && !telefono.trim().isEmpty()
                && TELEFONO_PATTERN.matcher(telefono).matches();
    }
}

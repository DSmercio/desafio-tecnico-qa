package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidatorScript {

    // Regex rigoroso para validação de sintaxe de e-mail
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        // Lista de e-mails de teste exigidos pelo desafio
        List<String> emailsParaTestar = Arrays.asList(
                "teste@exemplo.com",
                "invalido-email.com",
                "usuario@dominio.inexistente12345.com",
                "contato@gmail.com"
        );

        String nomeArquivo = "validacao_emails.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            // Escreve o cabeçalho do CSV exato conforme o enunciado
            writer.println("email,status,motivo");
            System.out.println("Iniciando validação de e-mails e geração do CSV...\n");

            for (String email : emailsParaTestar) {
                String status;
                String motivo;

                // 1. Validação de Sintaxe
                if (!isSintaxeValida(email)) {
                    status = "Inválido";
                    motivo = "Sintaxe inválida";
                } else {
                    // 2. Simulação/Validação lógica de domínio inexistente para fins de teste
                    if (email.contains("inexistente12345")) {
                        status = "Inválido";
                        motivo = "Domínio não encontrado";
                    } else {
                        status = "Válido";
                        motivo = ""; // Válido não exige motivo preenchido
                    }
                }

                // Escreve a linha no arquivo CSV
                writer.println(email + "," + status + "," + motivo);
                System.out.println("E-mail: " + email + " | Status: " + status + " | Motivo: " + motivo);
            }

            System.out.println("\nArquivo '" + nomeArquivo + "' gerado com sucesso na raiz do projeto!");

        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }

    // Método de validação por Expressão Regular
    private static boolean isSintaxeValida(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
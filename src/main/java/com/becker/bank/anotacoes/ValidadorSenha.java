package com.becker.bank.anotacoes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorSenha implements ConstraintValidator<Senha, String> {

    @Override
    public void initialize(Senha constraintAnnotation) {
        // Inicialização (não é necessário fazer nada aqui para validação de senha)
    }

    @Override
    public boolean isValid(String senha, ConstraintValidatorContext context) {
        // Verifica se a senha não é nula
        if (senha == null) {
            return false; // Se for nula, é inválida
        }

        boolean temNumero = false;
        boolean temMaiuscula = false;
        boolean temEspecial = false;

        // Verificando cada caractere da senha
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                temNumero = true;
            } else if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            } else if (!Character.isLetterOrDigit(c)) {
                temEspecial = true;
            }
        }

        // Se a senha não tiver pelo menos 8 caracteres
        if (senha.length() < 8) {
            context.buildConstraintViolationWithTemplate("A senha deve ter pelo menos 8 caracteres.")
                   .addConstraintViolation();
            return false;
        }

        // Se não tiver um número
        if (!temNumero) {
            context.buildConstraintViolationWithTemplate("A senha deve conter ao menos 1 número.")
                   .addConstraintViolation();
            return false;
        }

        // Se não tiver uma letra maiúscula
        if (!temMaiuscula) {
            context.buildConstraintViolationWithTemplate("A senha deve conter ao menos 1 letra maiúscula.")
                   .addConstraintViolation();
            return false;
        }

        // Se não tiver um caractere especial
        if (!temEspecial) {
            context.buildConstraintViolationWithTemplate("A senha deve conter ao menos 1 caractere especial.")
                   .addConstraintViolation();
            return false;
        }

        // Se todas as validações passarem, retorna true
        return true;
    }
}

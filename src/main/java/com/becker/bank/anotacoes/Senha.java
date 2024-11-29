package com.becker.bank.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorSenha.class) // Associa o validador
public @interface Senha {

    // Mensagem padrão
    String message() default "A senha não atende aos requisitos";

    // Agrupamento de validação (para personalização de grupos de validação)
    Class<?>[] groups() default {};

    // Definir a carga útil (caso necessário)
    Class<? extends Payload>[] payload() default {};
}

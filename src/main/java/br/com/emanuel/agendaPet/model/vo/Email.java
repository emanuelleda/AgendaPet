package br.com.emanuel.agendaPet.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true) // Jackson precisa disso para campos final
@AllArgsConstructor
public class Email {

    private final String endereco;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    private boolean isValid(String email) {
        return PATTERN.matcher(email).matches();
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return endereco.equals(email.endereco);
    }

    @Override
    public int hashCode() {
        return endereco.hashCode();
    }

    @Override
    public String toString() {
        return endereco;
    }
}
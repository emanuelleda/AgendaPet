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
public class Telefone {

    private final String numero;
    private static final String TEL_REGEX = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])\\d{3}-?\\d{4}$";
    private static final Pattern PATTERN = Pattern.compile(TEL_REGEX);

    private boolean isValid(String valor) {
        return PATTERN.matcher(valor).matches();
    }

    public String getFormatado() {
        assert numero != null;
        return numero.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        assert numero != null;
        return numero.equals(telefone.numero);
    }

    @Override
    public int hashCode() {
        assert numero != null;
        return numero.hashCode();
    }

    @Override
    public String toString() {
        return getFormatado();
    }
}
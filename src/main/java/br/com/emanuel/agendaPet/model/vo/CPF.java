package br.com.emanuel.agendaPet.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class CPF {
    private final String numero;

    private boolean isValid(String cpf) {
        return cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}");
    }

    public String getNumeroFormatado() {
        assert numero != null;
        return numero.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
package br.com.emanuel.agendaPet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class ErroResposta {
    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String mensagem;
    private String path;
}
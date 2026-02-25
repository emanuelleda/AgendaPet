package br.com.emanuel.agendaPet;

import br.com.emanuel.agendaPet.model.entity.Usuario;
import br.com.emanuel.agendaPet.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AgendaPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaPetApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (repository.findByLogin("recrutador") == null) {
				Usuario recrutador = new Usuario();
				recrutador.setLogin("recrutador");
				recrutador.setSenha(passwordEncoder.encode("pet123"));
				repository.save(recrutador);
				System.out.println(">>> USUARIO DE TESTE CRIADO: recrutador / pet123");
			}
		};
	}

}

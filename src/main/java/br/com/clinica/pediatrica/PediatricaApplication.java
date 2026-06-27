package br.com.clinica.pediatrica;

import br.com.clinica.pediatrica.models.entities.Usuario;
import br.com.clinica.pediatrica.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PediatricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PediatricaApplication.class, args);
	}

	// Este método roda automaticamente assim que você dá o Play no projeto
	@Bean
	public CommandLineRunner popularBanco(UsuarioRepository repository, PasswordEncoder encoder) {
		return args -> {
			// Verifica se o e-mail já existe para não duplicar
			if (repository.findByEmail("admin@clinica.com").isEmpty()) {
				Usuario admin = new Usuario();
				admin.setNome("Administrador");
				admin.setEmail("admin@clinica.com");
				admin.setSenha(encoder.encode("123456")); // O Spring criptografa a senha aqui

				repository.save(admin);
				System.out.println("✅ Usuário de teste criado com sucesso no banco de dados!");
			}
		};
	}
}

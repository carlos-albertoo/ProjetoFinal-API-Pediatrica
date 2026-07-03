# API Clínica Pediátrica

Projeto desenvolvido como requisito final da disciplina de **TÓPICOS AVANÇADOS EM COMPUTAÇÃO**. Esta API tem como objetivo gerenciar as atividades de uma clínica pediátrica, incluindo cadastro de usuários, pacientes, médicos e agendamento de consultas com validações de regra de negócio e segurança.

## 👥 Integrantes da Equipe

* **Carlos Alberto Moreira Da Silva** - RGM: 42214521
* **Thalyson Chaves Nunes** - RGM: 42066859

## 🛠️ Tecnologias Utilizadas

* **Linguagem**: Java 21+.
* **Framework**: Spring Boot 3.x.
* **Banco de Dados**: MySQL.
* **Gerenciador de Dependências**: Gradle.
* **Documentação**: OpenAPI / Swagger.
* **Segurança**: Spring Security com JWT.
* **Lombok**: Utilizado para redução de código boilerplate.

## 📋 Mapeamento de Conceitos (Requisitos Atendidos)

O projeto cumpre todos os requisitos obrigatórios da especificação:

| Conceito | Implementação no Projeto |
| --- | --- |
| **Relacionamento OneToOne** | Vinculação de `Usuario` e `Endereco`. |
| **Relacionamento OneToMany/ManyToOne** | Vínculos entre `Paciente`, `Pediatra` e `Consulta`. |
| **Entidade de Transação** | `Consulta` (centraliza a ação principal). |
| **Validação de Regra de Negócio** | Lógica de impedimento de agendamentos. |
| **Métricas In-Memory** | Endpoint `GET /consultas/resumo`. |
| **Segurança JWT** | Autenticação stateless com TokenService. |
| **Documentação Interativa** | Rotas documentadas via Swagger/OpenAPI. |

## 🛡️ Tratamento de Exceções

A API utiliza um `GlobalExceptionHandler` (via `@RestControllerAdvice`) para retornar mensagens de erro padronizadas em JSON:

* **400 Bad Request**: Erros de validação ou regras de negócio.
* **404 Not Found**: Registros não localizados.

## 🚀 Como Executar

1. Clone o repositório.
2. Configure o arquivo `application.yml` com as credenciais do seu banco de dados MySQL.
3. Execute a aplicação via IDE ou comando `./gradlew bootRun`.
4. Acesse a documentação no navegador: `http://localhost:8080/swagger-ui/index.html`.

## 📍 Principais Rotas e Fluxo de Teste

Para testar o fluxo completo da aplicação (via Postman ou Swagger), siga esta ordem para garantir a autenticação correta:

1. **Cadastro de Usuário (Rota Pública)**
    * `POST /usuarios` - Cria um novo usuário com nome, e-mail e senha.
2. **Autenticação (Rota Pública)**
    * `POST /auth/login` - Retorna o Token JWT (Bearer).
3. **Cadastros Protegidos (Requer Token)**
    * `POST /pediatras` - Cadastra um novo médico.
    * `POST /pacientes` - Cadastra um paciente vinculado ao ID do usuário.
4. **Transação Principal (Requer Token)**
    * `POST /consultas` - Realiza o agendamento cruzando dados de paciente e pediatra.
5. **Métricas In-Memory (Requer Token)**
    * `GET /consultas/resumo` - Retorna o painel atualizado com o total de consultas.
6. **Exclusão de Registros (Requer Token)**
    * `DELETE /usuarios/{id}` - Remove um usuário do sistema.
    * `DELETE /pediatras/{id}` - Remove um médico cadastrado.
    * `DELETE /pacientes/{id}` - Remove um paciente do sistema.
## 🎥 Demonstração (Vídeo)

* **Link do Vídeo no YouTube**: https://www.youtube.com/watch?v=Q-ulSF_0MFA

---
*Projeto desenvolvido seguindo rigorosamente as especificações técnicas da disciplina de TÓPICOS AVANÇADOS EM COMPUTAÇÃO.*

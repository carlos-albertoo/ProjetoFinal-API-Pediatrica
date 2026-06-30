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

## 🎥 Demonstração (Vídeo)

* **Link do Vídeo no YouTube**: [INSERIR LINK DO VÍDEO AQUI]

---
*Projeto desenvolvido seguindo rigorosamente as especificações técnicas da disciplina de TÓPICOS AVANÇADOS EM COMPUTAÇÃO.*

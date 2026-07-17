CRUD Itens

Uma API Restfull para cadastro, leitura, alteração e exclusão de itens.
---

Tecnologias e dependências

* **Java 25** 
* **Spring Boot 4.1.0**
* **Spring Security ** 
* **JWT (Json Web Token)**
* **Spring Data JPA** 
* **Banco de Dados:** 
* **Lombok** 
* **Springdoc OpenAPI / Swagger** 

---

Como rodar o projeto

### Pré-requisitos
* JDK 25 ou superior instalado.
* Maven instalado.
* No application.properties coloque api.security.token.secret=(sua chave secreta).

### Passos para Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/igoride/Crud.git
   cd crud
2. **Instale as dependências e compile**
   ```bash
   mvn clean install
3. **Execute a aplicação**
   ```bash
   mvn spring-boot run
4. **Acessar a documentação/API**
   http://localhost:8080/swagger-ui/index.html

### Estrutura do Projeto
src/main/java/com/exemplo/crud
```text
|--- configuration/ #Configurações de segurança e do Swagger
|--- controller/    # Controllers Rest
|--- dto/           # Objetos de transferências de dados
   |--- auth/
   |--- exception/
|--- entity/        # Entidades JPA
|--- exception/     # Tratamento de exceções
|--- repository/    # Interfaces JpaRepository
|--- security/      # JWT e filtros
|--- service/       # Interfaces e implementações de regras de negócio

# 🐾 Pet Shop API - Cadastro de Produtos

Esta é uma API REST para gerenciamento de produtos de um Pet Shop, desenvolvida com **Java 21** e **Spring Boot 3**. O projeto utiliza as melhores práticas de mapeamento de objetos (MapStruct), persistência de dados (JPA/H2) e redução de código boilerplate (Lombok).

## 🚀 Tecnologias Utilizadas

* **Java 21**: Versão LTS mais recente com foco em performance.
* **Spring Boot 3.2.2**: Framework base para a construção da API.
* **Spring Data JPA**: Para persistência de dados.
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes rápidos.
* **MapStruct**: Para conversão eficiente entre Entidades e DTOs.
* **Lombok**: Para geração automática de getters, setters e construtores.
* **JUnit 5 & Mockito**: Para testes unitários e de integração.
* **Maven**: Gerenciador de dependências e build.

---

## 🛠️ Configurações de Build (POM.xml)

Durante o desenvolvimento, o `pom.xml` foi refatorado para garantir a compatibilidade do Java 21 com os processadores de anotação. A ordem dos `annotationProcessorPaths` foi configurada especificamente para que o **Lombok** processe os dados antes do **MapStruct**:

1. `lombok`
2. `lombok-mapstruct-binding`
3. `mapstruct-processor`

---

## 📡 Endpoints da API

A API expõe os seguintes endpoints em `http://localhost:8080/produtos`:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/produtos` | Lista todos os produtos cadastrados. |
| **GET** | `/produtos/{id}` | Busca um produto específico pelo ID. |
| **POST** | `/produtos` | Cria um novo produto (Enviar JSON no Body). |
| **PUT** | `/produtos/{id}` | Atualiza um produto existente. |
| **DELETE** | `/produtos/{id}` | Remove um produto do sistema. |

### Exemplo de JSON para Criação (POST):
```json
{
  "nome": "Ração Premium Cão Adulto 15kg",
  "preco": 249.90
}

```
🧪 Testes Unitários e de Integração
O projeto conta com uma suíte de testes automatizados:

Service Test: Utiliza Mockito para isolar a regra de negócio da camada de dados.

Controller Test: Utiliza MockMvc para simular requisições HTTP e validar os Status Codes (200, 204, etc) e o retorno do JSON via jsonPath.



🔧 Como Rodar o Projeto
Certifique-se de ter o JDK 21 e o Maven instalados.

Clone o repositório.

Execute o comando para compilar e baixar as dependências:

O Console do H2 estará disponível em: [http://localhost:8080/h2-console](http://localhost:8080/produtos)

JDBC URL: jdbc:h2:mem:testdb

User: sa
Link Azure :https://bootcamp-produtos-ester-a5c7b4f8azekb9cn.brazilsouth-01.azurewebsites.net/
Password: (em branco)


📝 Notas de Implementação (Troubleshooting)
Encoding: O projeto foi configurado com UTF-8 para evitar erros de MalformedInputException em sistemas com diferentes encodings.

Injeção de Dependências: Foi utilizado o padrão de injeção via construtor (gerado pelo Lombok @RequiredArgsConstructor) para garantir a imutabilidade e facilitar os testes unitários.


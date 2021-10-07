# costumers
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Aplicação [Spring Boot](http://projects.spring.io/spring-boot/) que fornece uma API REST para cadastro de clientes. 

## Requisitos

Para fazer o build da aplicação é necessário

- OpenJDK 64-Bit Server VM AdoptOpenJDK 11.0.10+9
- Apache Maven 3.2.3

## Banco de dados
 A aplicação utiliza o Banco de Dados H2, integrado a mesma. Os dados de teste já estão persistidos no arquivo de dados `/dbfilez.mv.db`. Caso seja necessário restabelecer os dados iniciais, rodar o arquivo sql  em `/src/main/resources/data.sql`. 
URL para acessar o console do Banco de Dados: `http://localhost:8282/h2-console`

## Documentação
 URL para acessar documentação Swagger: `http://localhost:8282/swagger-ui.html`
 
## Executando o projeto

Para executar o projeto:

```
mvn compile
mvn spring-boot:run
```
Para executar os testes:
```
mvn tests
```

## Postman

  As definições de Endpoints do postman se encontram no arquivo `/costumers.postman_collection.json`

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.

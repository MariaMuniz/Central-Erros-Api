# Central-Erros-Api
Projeto Final do curso java online da Codenation.
Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos,
erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma,
é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar 
decisões mais acertadas. Neste projeto vamos implementar uma API Rest para centralizar registros de erros de aplicações.
MUDEI AQUI.,...

## Tecnologia

- [Java](https://www.oracle.com/technetwork/java/javase/downloads/index.html) ```1.8```
- [Spring Boot](https://spring.io/projects/spring-boot) ```2.1.7.RELEASE```
- [Maven](https://maven.apache.org/) ```3.6.2```
- [PostgreSQL](https://www.postgresql.org/) ```10.9``` 
- [Swagger](https://swagger.io/) ```2.9.2```
- [Docker](https://www.docker.com/) ```19.03.2 CE```

## Instalação

A aplicação foi configurada pra ser executada com o Maven, portanto será necessário a instalação dessa ferramenta. 

> Instalando o Maven: [https://maven.apache.org/install.html](https://maven.apache.org/install.html).

## Deploy

Para fins de demonstração de funcionamento, foi feito o deploy da aplicação na plataforma [Heroku](https://centralerroapi.herokuapp.com/)

## Endpoint

- https://centralerroapi.herokuapp.com/oauth/token(metodo POST, retorna o token)
- https://centralerroapi.herokuapp.com/users/1 (metodo GET, retorna usuário de id 1)
- https://centralerroapi.herokuapp.com/users (metodo POST, insere um usuario)
- https://centralerroapi.herokuapp.com/logs ( metodo GET, retorna todos os logs)





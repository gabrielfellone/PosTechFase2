


TechChallenge

Fase 2 - Pós 2ADJT

Aluno: Gabriel Fellone RM350771


Sobre a solução:

Pensei em abordar tudo que foi apresentado na Fase 2, usei o JPA com o PostGree, subi a imagem no Docker do banco de dados.
Usei o Swagger para facilitar os testes nos endpoints e documentação, usei o Spring com as Annotations apresentadas nas aulas.
Utilizei o Stream para filtrar dentro da service.
Apesar de um projeto simples, tentei abordar tudo que aprendi nesta fase.



Roteiro de teste:


O codigo esta no github na MASTER

https://github.com/gabrielfellone/PosTechFase2


Após baixar, subir a imagem do Postgres no Docker

Comandos:

docker pull postgres

docker run -d --name postgre-fiap -e POSTGRES_PASSWORD=102030 -p 5432:5432 postgres:latest

------

Para testar o código é possível entrar no Swagger através da URL 

http://localhost:8080/swagger-ui/index.html#/


Para o teste de sucesso segue endpoints abaixo com os payloads:


Parquimetro

{
  "id": 1,
  "manutencao": false,
  "status": "DISPONIVEL",
  "estado": "sp",
  "cidade": "sp",
  "cep": "12345"
}

Solicitar parquimetro

{
  "id": 1,
  "dtaInicio": "2024-01-28",
  "placa": "abc123",
  "id_parquimetro": 1,
  "id_credito": 1
}


Credito

{
  "id": 1,
  "metodo": "CREDITO",
  "placaCarro": "abc123",
  "valor": 10
}

Carro

  {
    "id": 1,
    "dtaInicio": "2024-01-27",
    "placa": "abc123"
  }






Sobre a arquitetura do código (resumida):

config – auxiliam na parte de configuração de um client, feign, api externa, properties etc.

controller – as classes de chamadas de api, camada de application, onde possui os endpoints e requests, responses

domain – as classes de entidades, dominios do sistema

exceptions – exceções personalizadas

integrations - integrações com outros serviços (exemplo: api google maps, api pagamentos, feign, etc.)

properties – arquivos de properties, contendo valores de configurações, urls, etc

repository – possui as classes/interfaces/entidades para banco de dados

services – classes de serviços para manipular os domains, regras de negócio, etc

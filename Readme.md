# 📨 Exemplos de configurações Spring Boot com serviço de mensageria Apache Kafka (producer e consumer).

Para facilitar a implementação do servidor Apache Kafka, utilize o _**Docker Compose**_:

```shell
$ docker-compose up
```

Para envio de objeto JSON aos *endpoints* das aplicações com producer, utilize o _**curl**_:

```shell
$ curl --location --request POST 'localhost:8080/kafka/createPerson' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Fulano", "age": 20}'
```



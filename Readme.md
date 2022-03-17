# 📨 Exemplos de configurações Spring Boot com serviço de mensageria Apache Kafka (producer e consumer).

Para facilitar a implementação do servidor Apache Kafka, utilize o _**Docker Compose**_:

```shell
$ docker-compose up
```

A *Config 4* é voltada para execução no Kubernetes. A partir de cada pasta (producer ou consumer), execute o script para realizar o *build* e o *push* da imagem:

```shell
$ ./build-docker.sh
```

Logo após, basta entrar no diretório **k8s**, que contém os manifestos, e executar:

```shell
$ kubectl apply -f kafka.yaml
$ kubectl apply -f producer.yaml
$ kubectl apply -f consumer.yaml
```

Para envio de objeto JSON aos *endpoints* das aplicações com producer, utilize o _**curl**_:

```shell
$ curl --location --request POST 'localhost:8080/kafka/createPerson' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Fulano", "age": 20}'
```



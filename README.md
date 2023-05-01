# microservice-security

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/microservice-security-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- REST Client Classic ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- OpenID Connect ([guide](https://quarkus.io/guides/security-openid-connect)): Verify Bearer access tokens and authenticate users with Authorization Code Flow

## Provided Code

### REST Client

Invoke different services through REST with JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

curl -X POST http://localhost:32800/realms/quarkus/protocol/openid-connect/token --user quarkus:password -H 'content-type: application/x-www-form-urlencoded' -d 'username=alice&password=alice&grant_type=token'

curl -X POST http://localhost:32800/realms/quarkus/protocol/openid-connect/token --user quarkus:password -H 'content-type: application/x-www-form-urlencoded' -d username=alice&password=alic&grant_type="grant_type=urn:ietf:params:oauth:grant-type:uma-ticket" --data 'username=alice&password=alice'

 curl --insecure -X POST http://localhost:32800/realms/quarkus/protocol/openid-connect/token --user backend-service:secret -H 'content-type: application/x-www-form-urlencoded' -d 'username=alice&password=alice&grant_type=password' | jq --raw-output '.access_token'


 curl --insecure -X POST http://localhost:32802/realms/quarkus/protocol/openid-connect/token --user backend-service:secret -H 'content-type: application/x-www-form-urlencoded' -d 'username=bob&password=bob&grant_type=password' | jq --raw-output '.access_token'

 curl -v -X GET http://localhost:8080/api/users/me -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJub0JMSG5nVUhLZGdoMUM2UzVnUHBoZlczV2FMSU1xY25nbnloa0pZOF80In0.eyJleHAiOjE2ODI2NzI3MTEsImlhdCI6MTY4MjY3MjExMSwianRpIjoiZjMxMjQzNzAtZjViMS00MTk4LTgxMTEtODNhYzg5YjMzZWY1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDozMjgwMi9yZWFsbXMvcXVhcmt1cyIsInN1YiI6IjhkODRmYzI3LWZkZmItNDNmYi1iMjdmLTk2OGZjOGZlMWFhZCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImJhY2tlbmQtc2VydmljZSIsInNlc3Npb25fc3RhdGUiOiJiODYxNGZhYy1hYWJiLTRkNjItYmVlZS00NjcyOTk3ZjQ2MTgiLCJzY29wZSI6Im1pY3JvcHJvZmlsZS1qd3QiLCJzaWQiOiJiODYxNGZhYy1hYWJiLTRkNjItYmVlZS00NjcyOTk3ZjQ2MTgiLCJ1cG4iOiJib2IiLCJncm91cHMiOlsidXNlciJdfQ.VPBPgjKjcbph21Ii9iWjMSPbsNEWf5BwzmJeGbhCVA1uJy1WlR3kvkBWR9FcFHIx-v85r130Ylnbhg6QoNJaVev6CZsz7ZJs4q9eDV6br3c0up_uQvpKEK7OrnbUjQsqDDJjAGobXGGO0xdLya6kvqmCKgHkSpWS7TKpCCxOmBBM4J8y49nIm8m3JABwHd3DZX2mn-s7cNyrHV2N7RBLyEqQCA1W0TdGNjDAhpkX9z0GSfxOxJV5BTK1pt8ZA32XKJkMWB1Ysn15EkLfT1YS8jX8A_U7mytuiZrLcNvtK6xwkzMg7CDuzRp2edvI0R8njyXrwqnbOMeMeSvWn4Tm2A"
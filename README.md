# spring-boot-jwt-sample2

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-jwt-sample2/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-jwt-sample2/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.x-6DB33F?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-336791?logo=postgresql)
[![Dependabot](https://img.shields.io/badge/Dependabot-enabled-025E8C?logo=dependabot)](.github/dependabot.yml)

Sample REST API for user registration & login secured with **Spring Security** and **JWT** (stateless authentication).

## Tech Stack

| Component           | Version      |
|---------------------|--------------|
| Java (JDK)          | 25 (Temurin) |
| Spring Boot         | 4.1.x        |
| Spring Security     | 7.1.x        |
| JJWT                | 0.13.x       |
| PostgreSQL          | 17           |
| Springdoc OpenAPI   | 3.x          |
| Lombok              | managed by Spring Boot |
| Testcontainers      | for integration tests |
| Maven Wrapper       | 3.10.x       |

## Prerequisites

- JDK 25
- Docker & Docker Compose (PostgreSQL and pgAdmin are started automatically via
  [Spring Boot Docker Compose support](https://docs.spring.io/spring-boot/reference/features/dev-services.html#features.dev-services.docker-compose)
  using `compose.yml`)

> Since JDK 23 `javac` no longer runs annotation processors implicitly. Lombok and
> `spring-boot-configuration-processor` are therefore registered explicitly in
> `maven-compiler-plugin` → `annotationProcessorPaths` in `pom.xml`.

## Getting Started

1. Clone this repository:
   ```shell
   git clone https://github.com/hendisantika/spring-boot-jwt-sample2.git
   ```
2. Navigate to the folder:
   ```shell
   cd spring-boot-jwt-sample2
   ```
3. Run the application (Docker Compose services are started automatically):
   ```shell
   ./mvnw clean spring-boot:run
   ```
4. Insert the default roles:
   ```sql
   INSERT INTO roles(id, name) VALUES (1, 'admin'), (2, 'user');
   ```
5. Open Swagger UI: http://localhost:8080/swagger-ui
6. Or test with Postman / `curl` (see below).

### Build & Test

```shell
./mvnw clean package
```

### Useful URLs

| URL                                    | Description            |
|----------------------------------------|------------------------|
| http://localhost:8080/swagger-ui       | Swagger UI             |
| http://localhost:8080/v3/api-doc       | OpenAPI docs (JSON)    |
| http://localhost:5050                  | pgAdmin                |

## API Endpoints

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| POST   | `/api/auth/register` | Register a new user     |
| POST   | `/api/auth/login`    | Login & get a JWT token |

Swagger UI

![Swagger UI](img/Swagger-UI.png "Swagger UI")

### Test API

Add New Data

![Add New Data](img/User-Registration.png "Add New Data")

```shell
curl -X 'POST' \
  'http://localhost:8080/api/auth/register' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "username": "sasuke",
  "password": "123456",
  "role": "admin"
}'
```

Login User Data

![Login User Data](img/User-Login.png "Login User Data")

```shell
curl -X 'POST' \
  'http://localhost:8080/api/auth/login' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "username": "naruto",
  "password": "123456"
}'
```

Response:

```shell
{
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXJ1dG8iLCJyb2xlcyI6WyJhZG1pbiJdLCJpYXQiOjE3Mjg3NzM4ODIsImV4cCI6MTcyODc3NDc4Mn0.8q9SARQZVOhVcZBi4E7NNDupzAWcehoLP1sh4_pA8fHByNg1TST9zh2jW6uIa6IkHiq0mYJB47BB1aJSb_kRLg",
  "tokenType": "Bearer "
}
```

Send the token as `Authorization: Bearer <accessToken>` header to access secured endpoints.

## CI/CD

GitHub Actions workflow [`.github/workflows/maven.yml`](.github/workflows/maven.yml) builds and tests the project
with **Temurin JDK 25** on every push and pull request to `main`.

## Dependency Updates (Dependabot)

[`.github/dependabot.yml`](.github/dependabot.yml) keeps dependencies up to date:

| Ecosystem        | Schedule (Asia/Jakarta) | Groups                                                                                  |
|------------------|-------------------------|-----------------------------------------------------------------------------------------|
| Maven            | daily 05:00             | `spring-boot`, `spring-security`, `jjwt`, `springdoc`, `testcontainers`, `maven-minor-patch` |
| GitHub Actions   | daily 05:00             | `github-actions`                                                                        |
| Docker Compose   | weekly (Monday) 05:00   | `docker-images` (PostgreSQL major upgrades are ignored)                                 |

Pull requests are labeled (`dependencies`, `java`, `github_actions`, `docker`) and use conventional commit prefixes
(`chore(deps)`, `ci(deps)`, `chore(docker)`).

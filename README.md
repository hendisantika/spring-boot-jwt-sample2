# spring-boot-jwt-sample2

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-jwt-sample2.git`
2. Navigate to the folder: `cd spring-boot-jwt-sample2`
3. Run the application: `mvn clean spring-boot:run`
4. Run this query: `INSERT INTO roles(name)	VALUES (1, 'admin'),(2, 'user');`
5. Open postman collection file
6. Test with POSTMAN App
7. Open Swagger UI: http://localhost:8080/swagger-ui

### Test API

Add New Data

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


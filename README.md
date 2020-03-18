A Spring Boot REST api to create, update and retrive Customers and Cities.<br />
Written in Java, H2 and Swagger.

Simply run the project on your favorite IDE.

To view H2 tables and records, open http://localhost:8080/h2-console

To view the API documentation, open http://localhost:8080/swagger-ui.html

To make requests to the API, use Insomnia or Postman.

Ex.:

URL: http://localhost:8080/city/ <br />
Method: PUT <br />
Body: {
  "name": "Joinville",
  "state": "SC"
}

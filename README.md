# password-validation-service
This microservice was built on kotlin and spring, and essentially it validates passwords through a REST API.


#### How to run
Clone the repository, and go to the root directory of the project and execute the following command:
```
./gradlew bootRun
```

Alternatively, you can open the project with an IDE with kotlin support like IntelliJ IDEA, where you can click with the right button on the file Application.kt and choose "Run Application.kt".

#### How to use

you can use a tool like postman or curl to make the requests. Here are the example curls for the existing endpoints, that you can import in your software of preference.

```
curl --location --request POST 'http://localhost:7000/passwords' \
--header 'Content-Type: application/json' \
--data-raw '{
   "password": "AbTp9!fok"
}'
```

```
curl --location --request GET 'http://localhost:7000/health-check' \
--header 'Content-Type: application/json'
```

You can still access the swagger documentation on a web browser with the endpoint 
```
http://localhost:7000/docs
```

OR

```
http://localhost:7000/swagger-ui/
```

#### Design decisions

The DDD (Domain driven design) was used to structure the microservice, using two layers only, application to receive requests and domain to store the business logic. The infrastructure layer was not used as persistence was not a requirement.

Unit tests were added to test each method and class, mainly on the domain layer, to validate business logic.

Component tests were added to validate the APIs, the requests and responses, as if the application was a black box.

The request was passed as a parameter to the interface of the domain service, which converts the request to the domain object, which in turn has all the listed business requirements. If an exception is thrown, this own service treats it and returns a Boolean. The application layer is responsible to converting it to a more presentable response. The fact that the domain logic is insinde the Password domain class makes it more object oriented, instead of some business rules thrown randomly across the service.

The domain service prints what is happening, to make resemblance to logs, which can provide troubleshooting in production environment.

#### Doubt points

The challenge had a statement that blank spaces were not valid, but it was just a note, not a rule like the others. So I had two options: to simply ignore white spaces, or to make it a rule to not allow any white spaces in the password. I thought the last option better as it sounds more reasonable.

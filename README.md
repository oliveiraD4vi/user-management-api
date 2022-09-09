
# User Management App

This is an app for simple user management using an Postgres database.

This project is under development, so to run this properly you will have to run the API and the Frontend App locally. You can found the [App here](https://github.com/oliveiraD4vi/user-management-app).

For addition, you do not need an local Postgres database, it is already using an Heroku Postgres Database, that will be available until the Heroku Free Apps limit, in 28th November 2022. Use only for testing.

## Installation

After clonning the repository or downloading the zip file of the application, import it to your IDE or open with VsCode.

If you have the right extensions in VsCode, you can run the application in debug mode.

If you are using an IDE, it should have the right plugins to run it in debug mode.

## Usage and Features

Once you have the API running, you will be able to access the path http://localhost:8080/ to do requests using your browser, the [Frontend App](https://github.com/oliveiraD4vi/user-management-app) or an application like Postman. The available paths are:

- POST /api/user -> Do a user registration;
- GET /api/user/list -> View a list of users based on pagination and searching;
- GET /api/user -> View an specific user information by Id;
- DELETE /api/user -> Delete a user passing it's id;
- PUT /api/user -> Update user information passing a user object;
- GET /api/consult -> Consult an specific user by RG or CPF attributes.

This application implements [Swagger](https://swagger.io/) documentation, so you can test the available requests before using it. To access the documentation you use the base pathname, in this case http://localhost:8080, adding /swagger-ui.html to the end.

#### Future Features

As the API only implements a User entity that do not have password or login attributes, features as password hashing or authorization and validation was'nt implemented. Those features will be implemented later as the application scope changes.

## Build with

* [SpringBoot](https://spring.io/projects/spring-boot/) - The Framework used
* [Swagger](https://swagger.io/) - The documentation UI for the API requests

## Version

See the [tags in this repository](https://github.com/oliveiraD4vi/user-management-api/tags).

## License
[MIT](https://choosealicense.com/licenses/mit/)

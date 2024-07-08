# Case Password API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

This project is an API built using **Java, Java Spring, H2 Database Engine as the database, and Spring Security for authentication control.** 

This API validates the password according to the requirements and logs the user into a frontend such as the repository: https://github.com/laralindsay/case-password-front.git.Ï

## Table of Contents

![Case validação senha clientes PF e PJ](https://github.com/laralindsay/case-password-api/assets/48735715/053c8eda-d314-4190-bb3e-0e806571113d)


## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/project-name.git
```

2. Install dependencies with Maven

3. Install h2 database:
   		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>4.4.0</version>
		</dependency>
  
## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /user - Retrieve a list of all users.

POST /users - Register a new user.

POST /auth/login - Login into the App

POST /auth/register - Register a new user into the App
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
ROLE_USER - Standard user role for logged-in users.
```

## Database
The project utilizes H2 Database Engine(https://mvnrepository.com/artifact/com.h2database/h2) as the database. 







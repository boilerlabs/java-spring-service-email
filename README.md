# 🚀 Java Spring Boot Email

![License](https://img.shields.io/github/license/boilerlabs/java-spring-service-email)
![Issues](https://img.shields.io/github/issues/boilerlabs/java-spring-service-email)
![Stars](https://img.shields.io/github/stars/boilerlabs/java-spring-service-email)

A boilerplate starter project for building a Java Spring Boot application with an E-mail Service. This template includes essential features for implementing an email service, such as sending emails, verifying email addresses, and resetting passwords.

## Table of Contents
1. [Features](#features)
2. [Getting Started](#getting-started)
3. [Usage](#usage)
4. [Contributing](#contributing)
5. [License](#license)

## Features
- Send text-based emails
- Send templated emails
- Email templates using Thymeleaf

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Installation
1. Clone the repository:

```bash
git clone https://github.com/boilerlabs/java-spring-service-email
cd java-spring-service-email
```

2. Configure the application properties in `src/main/resources/application.properties`:

```properties
spring.mail.host=myhost
spring.mail.port=587
spring.mail.username=myusername
spring.mail.password=mypassword
```

3. Running with Maven
```bash
mvn spring-boot:run
```

## Usage

The main feature of this project is the email service. The email service is implemented using the `EmailService` class. This class is responsible for sending text-based emails, and templated emails.

We have also implemented the `EmailController` class for you to test the email service. This controller has two endpoints:

### 1. Send a simple email
To send a simple text email, send a POST request to `/api/email/send` with the following JSON payload:

```json
{
    "to": "example_email",
    "subject": "example_subject",
    "body": "example_body"
}
```

### 2. Send a templated email
To send a templated email, send a POST request to `/api/email/send-template` with the following JSON payload:

```json
{
    "email": "example_email",
    "username": "example_username"    
}
```

## Templates

The email templates are stored in the `src/main/resources/templates` directory. The templates are written in Thymeleaf, a modern server-side Java template engine for web and standalone environments.

To create a new template, create a new HTML file in the `src/main/resources/templates` directory. Here is the templates we have included in this project:

- `welcome-email.html`: A welcome email template that greets the user.
- `verify-email.html`: A verify email template that allows the user to verify their email address.
- `reset-password-email.html`: A reset password email template that allows the user to reset their password.
- `marketing-email.html`: A marketing email template that promotes a product or service.

## Contributing
We welcome contributions! Please see the [CONTRIBUTING.md](./CONTRIBUTING.md) for more details.

## License
This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
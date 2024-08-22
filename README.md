# 🧠 - Arquitetura Hexagonal

- Projeto baseado em arquitetura hexagonal;
- Arquitetura Hexagonal, também conhecida como arquitetura de porta e adaptador (Ports and Adapters);
- É um estilo arquitetural de software que visa promover a separação de preocupações e a modularidade do sistema.

##

## 📂 - Estrutura de Pastas:
```
├── hexagonal
│   ├── adapters
│   |  ├── in
|   |  |  ├── consumer
|   |  |  ├── controller
|   |  ├── out
|   |  |  ├── client
|   |  |  |  ├── response
|   |  |  ├── repository
|   |  |  |  ├── entity
│   ├── application
│   |  ├── core
|   |  |  ├── domain
|   |  |  ├── exceptions
|   |  |  ├── usecase
│   |  ├── ports
│   |  ├── in
|   |  ├── out
│   ├── config
├── tests
```


## 📋 - Diagrama:
![hexagonal](https://github.com/user-attachments/assets/fca7c5ef-e79e-4590-a60a-a5040fab8153)

##

## ⚙️ - Tecnologias/Ferramentas:

- Kotlin;
- MongoDB;
- Docker;
- JUnit;
- Kafdrop;
- Spring Boot;
- Gradle;

# hr-management-system
Web system for managing job openings and employees, allowing registration and listing of information.

# 🚀 App RH

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Spring_Boot-3.5-green?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql" />
  <img src="https://img.shields.io/badge/Thymeleaf-Template-orange?style=for-the-badge" />
</p>

<p align="center">
  💼 Sistema completo de gerenciamento de Recursos Humanos desenvolvido com Spring Boot
</p>

---

## 📌 Sobre o projeto

O **App RH** é uma aplicação web que simula um sistema de gestão de recursos humanos, permitindo o controle de funcionários, vagas e candidatos em uma única plataforma. O sistema foi desenvolvido utilizando operações CRUD com Spring Data JPA, permitindo o cadastro, consulta, atualização e remoção de dados relacionados a funcionários, vagas e candidatos.”

O objetivo do projeto é aplicar conceitos de:

* Arquitetura MVC
* Persistência com JPA/Hibernate
* Templates dinâmicos com Thymeleaf
* Integração com banco de dados relacional

---

## ✨ Funcionalidades

✔️ Cadastro de funcionários  
✔️ Listagem de funcionários  
✔️ Cadastro de vagas  
✔️ Listagem de vagas  
✔️ Cadastro de candidatos  
✔️ Gerenciamento de dependentes  
✔️ Sistema de busca global 🔍  

---

## 🖥️ Demonstração


![_AppRH_-GoogleChrome2026-04-0317-25-53-ezgif com-video-to-gif-converter (1)](https://github.com/user-attachments/assets/3a93178f-2251-496a-8e25-ccdac8424a74)


Home page:
<img width="1366" height="640" alt="image" src="https://github.com/user-attachments/assets/6bfbca4b-b35b-46d4-9175-23896a619b44" />

Cadastro Vaga:
<img width="1366" height="640" alt="image" src="https://github.com/user-attachments/assets/e3458f26-87b2-4655-a2c5-73b83d68298c" />

Listar Vagas:
<img width="1366" height="640" alt="image" src="https://github.com/user-attachments/assets/44fa476e-4fb8-46a8-805f-7780fc624e70" />

Adcionar candidatos:
<img width="1366" height="645" alt="image" src="https://github.com/user-attachments/assets/35af189d-028d-400f-b82c-b2584727a9ce" />

Cadastrar funcionario:
<img width="1365" height="648" alt="image" src="https://github.com/user-attachments/assets/446b9ea4-d72f-41db-aff6-a03a499125b0" />

Listar Funcionário:
<img width="1366" height="644" alt="image" src="https://github.com/user-attachments/assets/f0308513-9e79-4ba8-aad7-fdb25616e731" />


---
## 🛠️ Tecnologias utilizadas

| Tecnologia      | Descrição             |
| --------------- | --------------------- |
| Java 21         | Linguagem principal   |
| Spring Boot     | Framework backend     |
| Spring Data JPA | Persistência de dados |
| Hibernate       | ORM                   |
| Thymeleaf       | Template engine       |
| PostgreSQL      | Banco de dados        |
| Bootstrap       | Interface             |

---

## ⚙️ Como executar

### 🔧 Pré-requisitos

* Java 21+
* Maven
* PostgreSQL

---

### 📥 Clone o projeto

```bash
git clone https://github.com/seu-usuario/app-rh.git
cd app-rh
```

---

### 🗄️ Configure o banco

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/app_rh
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### ▶️ Execute a aplicação

```bash
mvn spring-boot:run
```

---

### 🌐 Acesse

```
http://localhost:8081
```



Desenvolvido por **Ygor Mateus**

---

## ⭐ Se gostou do projeto

Deixe uma estrela ⭐ no repositório!


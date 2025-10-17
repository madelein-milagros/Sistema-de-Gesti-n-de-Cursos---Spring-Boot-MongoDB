# 🎓 Sistema de Gestión de Cursos - Spring Boot & MongoDB

Una aplicación web completa para la gestión de cursos académicos desarrollada con Spring Boot y MongoDB Atlas.

## ✨ Características

- ✅ **CRUD Completo** - Crear, Leer, Actualizar y Eliminar cursos
- 🎨 **Interfaz Moderna** - Diseño responsive con Bootstrap 5
- ☁️ **Base de Datos en la Nube** - MongoDB Atlas
- 🔍 **Búsqueda en Tiempo Real** - Filtrado por nombre de curso
- 📱 **Diseño Responsive** - Compatible con todos los dispositivos

## 🛠️ Tecnologías Utilizadas

- **Backend:** Spring Boot 2.7.0
- **Base de Datos:** MongoDB Atlas
- **Frontend:** Thymeleaf, Bootstrap 5, JavaScript
- **Herramientas:** Maven, Git, Spring Data MongoDB

## 🚀 Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.madelein-milagros/prj-crud-spring-boot-mongodb.git

  Configurar la base de datos:

Crear una cuenta en MongoDB Atlas

Configurar las credenciales en application.properties

Ejecutar la aplicación:

bash

Download
mvn spring-boot:run
Abrir en el navegador:

text


Download
http://localhost:8080/cursos

📁 Estructura del Proyecto
text

Download
src/
├── main/
│   ├── java/
│   │   └── com/ejemplo/escuela/
│   │       ├── Application.java
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── templates/
│       ├── static/
│       └── application.properties
└── test/
🎯 Endpoints Principales
GET /cursos - Lista todos los cursos

GET /cursos/nuevo - Formulario para nuevo curso

POST /cursos/guardar - Guardar curso

GET /cursos/editar/{id} - Editar curso existente

GET /cursos/eliminar/{id} - Eliminar curso

📸 Capturas de Pantalla
Interfaz moderna y responsive para gestión de cursos

👨‍💻 Autor
Milagros Madelein Ramos Ch.

📄 Licencia
Este proyecto es para fines educativos como parte del curso de Desarrollo de Aplicaciones Web.

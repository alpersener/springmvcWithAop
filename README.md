# springmvcWithAop
This project covers basic CRUD operations with Thymeleaf and using Spring Security
## Features
- The project is implemented using the Controller-Service-Repository pattern.
- Using AOP for Logs
- Implements the DTO pattern using ModelMapper.
- Uses MYSQL as a database.
- The project utilizes a custom authentication system with bcrypt-encrypted passwords and role-based access restrictions. User roles and passwords are managed in the project's database.
- Using Thymeleaf

| Endpoint                        | Role      |
|---------------------------------|-----------|
| /api/students/list              | PRINCIPAL |
| /api/students/showFormForAdd    | PRINCIPAL |
| /api/students/showFormForUpdate | PRINCIPAL |
| /api/students/listforstudents   | STUDENT   |
| /api/students/listforstudents   | PRINCIPAL |



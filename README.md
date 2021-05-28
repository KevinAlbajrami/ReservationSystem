# ReservationSystem
Java Restful Spring App Microservice
This flight reservation application allows users to create accounts, login, reserve flights as USERS while as (ADMIN_ROLE) a user can also create flights, delete and edit them.
Upon reserving a flight the user is delivered a generated pdf (with flight details) to their email address. Any visitor can also send an email to the company via a basic contact us form. 
This project (still under development) implements all the basics of SPRING mostly focused on SPRING BOOT
including:

REST Services

Database Management (JPA/Hibernate)

Validation

Exceptions

Roles

Security

Filters

with other functionalities such as:

PDF generation

Email Sending

On branch "master" there is a client CheckIn microservice uploaded that does simple get and put request to the main ReservationSystem microservice

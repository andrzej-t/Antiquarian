## ANTIQUARIAN - library management system. 

This is a backend project based on SpringBoot, IN WHICH I LEARN MYSELF how to use Spring Security and JWT for 
authentication and authorization.  Apart from Spring security, I use Lombok and Thymeleaf libraries in it. 
To run download the project, create database and it`s user, than
run it locally on the default port and use test data for login. You can log in directly in your browser by form login (http://localhost:8080/login) 
and also logout (http://localhost:8080/logout)
Endpoints You can test via Postman with using credentials listed below.

TEST DATA:

* READER: <br />
username: reader <br />
password: reader <br />

Example READER endpoints for testing:

http://localhost:8080/v1/book/all

* LIBRARIAN: <br />
username: librarian <br />
password: librarian <br />

Example LIBRARIAN endpoints for testing:

GET http://localhost:8080/v1/book/author?authorSurname=Surname1 <br />
GET http://localhost:8080/v1/book/title?title=Title5 <br />
GET http://localhost:8080/v1/book/2 <br />
GET http://localhost:8080/v1/book/all <br />
GET http://localhost:8080/v1/book/signature?signature=Signature1 <br />
PUT http://localhost:8080/v1/book/changeStatus/1?bookStatus=LOST <br />
PUT http://localhost:8080/v1/book/changeSignature/1?signature="S1" <br />
<br />
GET http://localhost:8080/v1/reader/surname?readerSurname=Surname1 <br />
GET http://localhost:8080/v1/reader/2 <br />
GET http://localhost:8080/v1/reader/all <br />
<br />
GET http://localhost:8080/v1/borrowing/all <br />
GET http://localhost:8080/v1/borrowing/readerId/2 <br />
GET http://localhost:8080/v1/borrowing/bookId/1 <br />

* ADMIN: <br />
username: admin <br />
password: admin <br />

Example ADMIN endpoints for testing:

All LIBRARIAN authorities

## ANTIQUARIAN - library management system. 

This is a backend project based on SpringBoot, in which I use Spring Security for authentication and authorization.  Appart from Spring security, I use Lombok and Thymeleaf libraries in it. To run download the project, run it locally on the default port (example: http://localhost:8080/login) and use test data for login. Endpoints You can test via Postman or directly in browser. For login out You can use logout button or http://localhost:8080/logout


CURRENTLY, THE PROJECT IS STILL UNDER CONSTRUCTION

TEST DATA:

* READER:
username: reader
password: reader

Example READER endpoints for testing:

http://localhost:8080/v1/book/all


* LIBRARIAN:
username: librarian
password: librarian

Example LIBRARIAN endpoints for testing:

http://localhost:8080/v1/book/all
http://localhost:8080/v1/book/1
http://localhost:8080/v1/book/title?title=title1
http://localhost:8080/v1/book/author?authorSurname=author1
http://localhost:8080/v1/book/signature?signature=signature1

http://localhost:8080/v1/reader/all
http://localhost:8080/v1/reader/surname?readerSurname=surname1
http://localhost:8080/v1/reader/1

http://localhost:8080/v1/borrowing/all
http://localhost:8080/v1/borrowing/readerId/1
http://localhost:8080/v1/borrowing/bookId/1

* ADMIN:
username: admin
password: admin

Example ADMIN endpoints for testing:

All LIBRARIAN authorities

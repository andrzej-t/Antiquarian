## ANTIQUARIAN - library management system. 

This is a backend project based on SpringBoot, in which I use Spring Security for authentication and authorization.  Appart from Spring security, I use Lombok and Thymeleaf libraries in it. To run download the project, run it locally on the default port (example: http://localhost:8080/login) and use test data for login. Endpoints You can test via Postman or directly in browser. For login out You can use logout button or http://localhost:8080/logout


CURRENTLY, THE PROJECT IS STILL UNDER CONSTRUCTION!!!

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

http://localhost:8080/v1/book/all <br />
http://localhost:8080/v1/book/1 <br />
http://localhost:8080/v1/book/title?title=title1 <br />
http://localhost:8080/v1/book/author?authorSurname=author1 <br />
http://localhost:8080/v1/book/signature?signature=signature1 <br />
<br />
http://localhost:8080/v1/reader/all <br />
http://localhost:8080/v1/reader/surname?readerSurname=surname1 <br />
http://localhost:8080/v1/reader/1 <br />
<br />
http://localhost:8080/v1/borrowing/all <br />
http://localhost:8080/v1/borrowing/readerId/1 <br />
http://localhost:8080/v1/borrowing/bookId/1 <br />

* ADMIN: <br />
username: admin <br />
password: admin <br />

Example ADMIN endpoints for testing:

All LIBRARIAN authorities

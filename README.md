# CRUD-JAVA
O projeto visa apresentar um CRUD feito em JAVA <br>

Aluno: Rafael dos Santos <br><br>
<h3> Modelo banco de dados - SQL </h3> <br><br>

create database bancoAgencia;<br>
use bancoAgencia;<br>
create table Cliente (<br>
id integer Primary Key auto_increment, <br>
nome varchar (100) not null, <br>
dataNasc date not null, <br>
login varchar (50) not null, <br>
senha varchar (50) not null <br>
)<br>
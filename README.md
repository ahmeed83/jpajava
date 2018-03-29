!-------------------`run docker container`--------------------------------!

$docker run -p 3306:3306 -d --name mysql -e MYSQL_ROOT_PASSWORD=password mysql/mysql-server

!-------------------`log in mysql in the docker container`--------------------------------!

$docker exec -it mysql bash
bash-4.2# mysql -uroot -ppassword
mysql>

!---------------------`make a new user name and password`------------------------------!

bash-4.2# mysql -uahmed -ppassword

!----------------------`give rights`-----------------------------!

mysql> CREATE USER 'arun'@'%' IDENTIFIED BY 'password';
Query OK, 0 rows affected (0.00 sec)
mysql> GRANT ALL PRIVILEGES ON * . * TO 'arun'@'%';
Query OK, 0 rows affected (0.00 sec)
mysql> quit

!-------------------------`don't forget to test it in Intellij`--------------------------!



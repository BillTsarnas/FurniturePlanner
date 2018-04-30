# FurniturePlanner

To deploy this web application, you need to perform the following steps:
1.	You need to Install MYSQL Server 5.7 or above. Here is a link to the manual on how to do it step by step (https://dev.mysql.com/doc/mysql-installation-excerpt/5.5/en/windows-install-archive.html) 

2.	Install Glassfish Server 3.1 or above. Here is a link to the manual on how to do it step (https://docs.oracle.com/cd/E26576_01/doc.312/e24935/installing.htm#GSING00002 )

3.	Copy the MYSQL driver jar that is contained in the repository ~\FurniturePlanner\database\ mysql-connector-java-5.1.46.jar  and place it on the Glassfish Server installation under the lib folder, like this glassfish3\glassfish\lib.
                      
4.	Connect to the admin console of Glassfish Server, usually http://localhost:4848 and on the left side under resources you are going to find JDBC and inside it JDBC Resources and Connection pools JDBC. 

5.	Create a connection pool on name of the pool type : furniture_pool, on resource type : javax.slq.DataSource and on Database Provider : MYSQL

6.	Setup the properties of the database regarding your own database portNumber, databaseName, serverName, user and password. For example in our case it was portNumber: 3306, databaseName: FurniturePlanner ServerName:LocalHost, User:Root and password:adminadmin.

7.	To validate that the pool is setup correctly on the general tab click “Ping" and make sure is successful.

8.	Once the connection pool is setup properly, we are going to the JDBC resources and we are creating a new resource with the specified JNDI Name "jdbc/furniture_planner" and select the pool that we just created ""furniture_pool".

9.	Setting up the database scripts, on our repository you can find under the folder ~\FurniturePlanner\database\  4 scripts that need to be executed on the database in the following order.

i)	FurniturePlannner.sql 
ii)	sp_get_clients_by_name.sql
iii)sp_get_orders_by_name.sql
iv)	sp_util_string_split.sql

10.	The web application is on the repository under the folder ~\FurniturePlanner\readme and installer\FurniturePlanner.war, we are going to select this file on the next screen and click accept.

11.	On the left side of the GlassFish admin console under applications there should be the FurniturePlanner.

12.	The application should be running and ready now so to test it here is the local link http://localhost:8080/FurniturePlanner/intro.jsp Enjoy!
  
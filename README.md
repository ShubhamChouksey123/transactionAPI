
# Transaction Object API  
#### By - Shubham Chouksey

## General info
This is a small Spring Boot Project that has an API endpoint /api which gets the transaction and saved in the DB
##### The screenShots of the working can be found here - https://drive.google.com/drive/folders/1e63MQ9aC36oAftxr6Ba-suQNKipeSquU?usp=sharing 


## Build Steps
* Import the project in Eclipse 
* Create a schema in MySQL or any other DB with query - 
    ```shell script
    CREATE SCHEMA `transactions` ;
    ```

   

* Change the DataBase Configurations in the file /transactions/src/main/resources/hibernate.properties
    in line 6 and 7 
    ```shell script
    jdbc.user = %DB_USERNAME%
    jdbc.password = %DB_PASSWORD%
    ```
    
* build the project using - mvn clean install
* Run the project using from the root directry location of the project - mvn spring-boot:run 
* OR you build and Run using the Eclipse build and And Run button 


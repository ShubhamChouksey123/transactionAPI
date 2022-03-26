
# Transaction Object API  
#### By - Shubham Chouksey

## General info
This is a small Spring Boot Project that has an API endpoint /api which gets the transaction and saved in the DB
##### The screenShots of the working can be found here - https://drive.google.com/drive/folders/1e63MQ9aC36oAftxr6Ba-suQNKipeSquU?usp=sharing 


## Build Steps
* Clone the project using -
    ```shell script
    git clone https://github.com/ShubhamChouksey123/transactionAPI
    ```
    ```shell script
    cd transactionAPI/
    ```
* Import the project in Eclipse 
* Create a schema in MySQL or any other DB using the query - 
    ```shell script
    CREATE SCHEMA `transactions` ;
    ```

   

* Change the DataBase Configurations in the file /transactions/src/main/resources/hibernate.properties
    in line 6 and 7 
    ```shell script
    jdbc.user = %DB_USERNAME%
    jdbc.password = %DB_PASSWORD%
    ```
    
* build the project using - 
    ```shell script
    mvn clean install
    ```
* Run the project using from the root directry location of the project -
    ```shell script
    mvn spring-boot:run 
    ```
* OR you build and Run using the Eclipse build and And Run button 


## Testing API
* From the Git Bash 
    ```shell script
    curl --header 'Content-Type: application/json' --data '
    {
    "id":1,
    "jsonrpc":"2.0",
    "method":"setTransactionInfo",
    "params":{
        "Transaction":{
            "accountNumber":"98008",
            "type":"DEBIT",
            "amount":"10",
            "currency":"USD",
            "accountFrom":"101010"
        }
    }
    }' --url http://localhost:8080/api 
    ```
* OR you can also test from the Postman 
    * Method Type - Post
    * URL - http://localhost:8080/api
    * Header 
        * Key - Content-Type
        * Value - application/json
    * Body 
        ```shell script        
        {
        "id":1,
        "jsonrpc":"2.0",
        "method":"setTransactionInfo",
        "params":{
            "Transaction":{
                "accountNumber":"98008",
                "type":"DEBIT",
                "amount":"10",
                "currency":"USD",
                "accountFrom":"101010"
            }
        }
        ```
* ALso you can Verify the TransactionInfo will be saved in DB

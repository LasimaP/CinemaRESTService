# CinemaRESTService
## Overview
The Cinema Rest API Application generates a 9x9 theater and allows the user to view, purchase, and return a selected ticket. The user may use a password to view private statistics such as available seats, profit made, and how many tickets sold.
## Postman Overview
1. Use **GET** localhost:28852/seats to see all the available seats
* A sample response would be:
```
{
    "total_rows": 9,
    "total_columns": 9,
    "available_seats": [
        {
            "row": 1,
            "column": 1,
            "price": 10
        },
        {
            "row": 1,
            "column": 2,
            "price": 10
        }, ...
}
```
2. Use **POST** localhost:28852/purchase to buy a ticket
* Go to **Body**
* Under Body click **raw**
* Select **JSON**
* In the body a sample input would be: 
```
{
    "row": 5,
    "column": 4
}
```
* A sample response would be:
```
{
    "token": "934fd7e6-3348-43b8-aacd-8087b8845269",
    "ticket": {
        "row": 5,
        "column": 4,
        "price": 8
    }
}
```
3. Use **POST** localhost:28852/return to return a ticket
* Go to **Body**
* Under Body click **raw**
* Select **JSON**
* In the body a sample input would be: 
```
{
   "token": "10b7e1a9-0faa-47ff-942d-55a00b67c0ac"
}
```
**NOTE:** token should be the same as purchased ticket
* A sample response would be:
```
{
    "returned_ticket": {
        "row": 5,
        "column": 4,
        "price": 8
    }
}
```
4. Use **POST** localhost:28852/stats?password=super_secret to get Cinema statistics.
* A sample response would be:
```
{
    "current_income": 8,
    "number_of_available_seats": 80,
    "number_of_purchased_tickets": 1
}
```









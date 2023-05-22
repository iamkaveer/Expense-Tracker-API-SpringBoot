# Expense-Tracker-API-SpringBoot

## Introduction
The Expense Tracker API is a powerful tool that allows users to effortlessly track their expenses. With this API, users can create, read, update, and delete expenses, as well as generate comprehensive reports on a monthly or weekly basis. To ensure secure access, users are required to sign in or register before utilizing the API's functionalities.

Features:
1. Expense Management: Users can create and manage their expenses with detailed information, including the product title, description, price, date, time, and associated user ID.
2. Fetching Expenses: The API provides an endpoint to fetch all the expenses for a particular date and time. Users can specify the desired date, and optionally, the time, to retrieve relevant expense records.

3. Total Expenditure Calculation: Users can request the API to generate the total expenditure for a given month. By providing the desired month, the API calculates and returns the cumulative expenses incurred by the user during that period.

4. Database and Deployment: The API utilizes a MySQL database to store expense records, ensuring data persistence. The deployment link's IP address is static, offering consistent access to the API and its functionalities.

5. Validation: The Expense Tracker API implements annotation-based validation to ensure data integrity and reliability. This validation process helps prevent erroneous or incomplete data from being stored or processed.

## Frameworks and language used:
1. Spring boot
2. Java
3. Maven
4. MySql
5. AWS for deployment

## Controllers
1. UserController : Handles user registration and login requests.
2. ProductController : Handles expense request such as create update delete etc by user

## Service
1. UserService : Handles user registration and login requests business logic.
2. ProducService : Handles all the business logic related to expense such as create, delete etc.

## Repository
1. UserRepository : Communicates with the database for user-related operations.
2. ProducRepository : Communicates with the database for expense related operations

## Data Model
1. User
2. Product
3. AuthenticationToken

id ->    integer	   ->  The unique ID of the expense

title	     ->       string	   ->     The title of the expense

description    ->  	string	    ->    The description of the expense

price	    ->        int	      ->    The price of the expense

date	     ->       date	   ->       The date of the expense

userEmail    ->   	string	   ->     The email of the user who created the expense

## VIDEO LINK : https://www.youtube.com/watch?v=XQmn4AZnKM0

[![Video](https://img.youtube.com/vi/XQmn4AZnKM0/0.jpg)](https://www.youtube.com/watch?v=XQmn4AZnKM0)



## Project Summary:
The Expense Tracker API is a RESTful API that allows users to track their expenses. The API supports creating, reading, updating, and deleting expenses, and generating reports on a monthly or weekly basis. Users are required to sign up and sign in to use the API.

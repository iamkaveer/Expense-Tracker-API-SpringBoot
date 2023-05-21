# Expense-Tracker-API-SpringBoot

## Introduction
The Expense Tracker API is a powerful tool that allows users to effortlessly track their expenses. With this API, users can create, read, update, and delete expenses, as well as generate comprehensive reports on a monthly or weekly basis. To ensure secure access, users are required to sign in or register before utilizing the API's functionalities.

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


## Project Summary:
The Expense Tracker API is a RESTful API that allows users to track their expenses. The API supports creating, reading, updating, and deleting expenses, and generating reports on a monthly or weekly basis. Users are required to sign up and sign in to use the API.

# Bus Booking Platform        {Still doing}

Welcome to the Bus Management System, a robust Spring Boot application designed to manage buses, users, bookings, and payments effectively. This project provides functionalities for CRUD operations on buses, user management, booking management, and payment processing.

## Frameworks and Technologies

This project utilizes the following frameworks and technologies:

- **Java**: The primary programming language used for backend development.
- **Spring Boot**: A powerful framework for building Java-based applications.
- **Spring Data JPA**: Simplifies data access and manipulation using the Java Persistence API (JPA).
- **MySQL**: The chosen relational database management system.
- **Swagger**: For API documentation and testing.

## Project Structure

The project is structured into several components:

- **Controller**: Defines endpoints and handles HTTP requests.
- **Service**: Implements business logic and interfaces with repositories.
- **Repository**: Manages data access and manipulation with the database.
- **Model**: Represents entities that are mapped to database tables.

## Features and Functionality

### API Endpoints

#### User Controller

- **Create User**
  - **Endpoint:** `/User/create`
  - **Method:** `POST`
  - **Description:** Creates a new user with the provided details.

- **Update User**
  - **Endpoint:** `/User/update`
  - **Method:** `PUT`
  - **Description:** Updates an existing user with the provided details.

- **Delete User**
  - **Endpoint:** `/User/delete/{userId}`
  - **Method:** `DELETE`
  - **Path Variable:** `userId` (Long)
  - **Description:** Deletes a user by user ID.

- **Get All Users**
  - **Endpoint:** `/User/getData`
  - **Method:** `GET`
  - **Description:** Retrieves details of all users.

#### Bus Controller

- **Create Bus**
  - **Endpoint:** `/Bus/create`
  - **Method:** `POST`
  - **Description:** Creates a new bus with the provided details.

- **Update Bus**
  - **Endpoint:** `/Bus/update`
  - **Method:** `PUT`
  - **Description:** Updates an existing bus with the provided details.

- **Delete Bus**
  - **Endpoint:** `/Bus/delete/{busId}`
  - **Method:** `DELETE`
  - **Path Variable:** `busId` (String)
  - **Description:** Deletes a bus by its ID.

- **Get All Buses**
  - **Endpoint:** `/Bus/getAllBuses`
  - **Method:** `GET`
  - **Description:** Retrieves details of all buses.

- **Get Bus By Name**
  - **Endpoint:** `/Bus/getBusByName/{busName}`
  - **Method:** `GET`
  - **Path Variable:** `busName` (String)
  - **Description:** Retrieves details of buses by name.

- **Get Buses By Source, Destination, and Date**
  - **Endpoint:** `/Bus/getBusBySourceAndDestinationByTime/{source}/{destination}/{date}`
  - **Method:** `GET`
  - **Path Variables:**
    - `source` (String)
    - `destination` (String)
    - `date` (Date)
  - **Description:** Retrieves details of buses by source, destination, and date.

- **Get Buses By Departure Time**
  - **Endpoint:** `/Bus/getBusBytime/{time}`
  - **Method:** `GET`
  - **Path Variable:** `time` (Timestamp)
  - **Description:** Retrieves details of buses by departure time.

- **Get Buses By Type**
  - **Endpoint:** `/Bus/busType/{busType}`
  - **Method:** `GET`
  - **Path Variable:** `busType` (BusType)
  - **Description:** Retrieves details of buses by type (e.g., AC, Non-AC).

- **Get Connected Buses**
  - **Endpoint:** `/Bus/connectedBuses/{firstBusSource}/{secondBusDestination}`
  - **Method:** `GET`
  - **Path Variables:**
    - `firstBusSource` (String)
    - `secondBusDestination` (String)
  - **Description:** Retrieves details of connected buses based on source and destination.

- **Get Bus By Bus ID**
  - **Endpoint:** `/Bus/getBusByBusId/{busId}`
  - **Method:** `GET`
  - **Path Variable:** `busId` (String)
  - **Description:** Retrieves details of a bus by its ID.

#### Login Controller

- **User Login**
  - **Endpoint:** `/Login/UserLogin`
  - **Method:** `POST`
  - **Description:** Authenticates user login credentials.

#### Bookings Controller

- **Create Booking**
  - **Endpoint:** `/Booking/createBooking`
  - **Method:** `POST`
  - **Description:** Creates a new booking with the provided details.

- **Get Booking By ID**
  - **Endpoint:** `/Booking/{bookingId}`
  - **Method:** `GET`
  - **Path Variable:** `bookingId` (String)
  - **Description:** Retrieves booking details by booking ID.

- **Get All Bookings**
  - **Endpoint:** `/Booking/allBookings`
  - **Method:** `GET`
  - **Description:** Retrieves details of all bookings.

#### Payment Controller

- **Get Payment By ID**
  - **Endpoint:** `/payments/{paymentId}`
  - **Method:** `GET`
  - **Path Variable:** `paymentId` (String)
  - **Description:** Retrieves details of a payment by its ID.

- **Initiate Payment**
  - **Endpoint:** `/payments/doPayment`
  - **Method:** `POST`
  - **Description:** Initiates a payment transaction.

- **Get All Payments**
  - **Endpoint:** `/payments/allPayments`
  - **Method:** `GET`
  - **Description:** Retrieves details of all payments.

## Getting Started

To run this project locally, follow these steps:

1. Clone the repository from GitHub.
2. Configure the application properties with your database credentials.
3. Build the project using Maven.
4. Run the application using Spring Boot.




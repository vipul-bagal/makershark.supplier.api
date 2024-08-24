# makershark.supplier.api

## Overview

This Spring Boot project provides an API for managing and querying suppliers and manufacturing processes. The project includes endpoints to create, read, and search for suppliers based on various criteria.

I've created a configuration to insert number of manufacturing processes and supplier records at initialization so that API results can be checked/experienced directly by running the application.

Now, follow below steps to see API in action.

## Prerequisites

- **Java 17:** Ensure you have Java 17 installed on your machine. You can download it from the [official Java website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Maven:** The project uses Maven for dependency management and building. Ensure you have Maven installed. You can download it from [Maven's official website](https://maven.apache.org/download.cgi).
- **IDE:** IntelliJ IDEA is recommended for development. You can download it from [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or use any other IDE of your choice.

## Getting Started

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/vipul-bagal/makershark.supplier.api.git
cd makershark.supplier.api
```

### 2. Build the Project

Run the following command to build the project.

```bash
mvn clean install
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

## Steps to consume API

### 1. Open the Postman application

URL
```bash
localhost:8080/api/supplier/query
```

request body(raw, JSON):
```bash
{
    "location": "Delhi",
    "businessType": "medium_scale",
    "manufacturingProcesses": ["3d_printing", "cnc_machining"],
    "pageNumber": 0,
    "size": 4
}

```

You can change the request params using the data below to check results:

location: "Mumbai", "Delhi", "Bengaluru"

BusinessType: "small_scale", "medium_scale", "large_scale"

manufacturing processes: "moulding", "3d_printing", "casting", "coating"







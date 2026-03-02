# 🔧 FixFlow — Complaint Management System

> A Full Stack web application to manage complaints efficiently with role-based access control.

## Stack Used 
1.[Java]
2.[Spring Boot]
3.[React]
4.[H2]

---

##  About The Project

**FixFlow** is a complaint management system where:
-  **Users** ---> can submit complaints
-  **Admins** --->can assign technicians to complaints
-  **Technicians** ---> can close assigned complaints

---

##  Tech Stack

###  Frontend

| Technology       | Version 
|------------------|---------
| React.js         | 19.2.0 
| Vite             | 7.3.1 
| Axios            | 1.13.5 
| React Router DOM | latest 
| CSS3             | - 

### ⚙️ Backend

| Technology      | Version 
|-----------------|----------
| Java            | 17 
| Spring Boot     | 3.5.9 
| Spring Data JPA | - 
| Spring Security | - 
| H2 Database     | - 
| Maven           | - 

---

## 📁 Project Structure
```
fixflow/
│
├──  fixflow/                    ← Spring Boot Backend
│   ├── src/main/java/com/fixflow/fixflow/
│   │   ├──  config/             ← CORS & Security Config
│   │   ├──  controller/         ← REST API Controllers
│   │   ├──  dto/                ← Request & Response DTOs
│   │   ├──  entity/             ← JPA Entities
│   │   ├──  enums/              ← ComplaintStatus Enum
│   │   ├──  exception/          ← Custom Exceptions
│   │   ├──  repository/         ← JPA Repositories
│   │   └──  service/            ← Business Logic
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
│
└──  fixflow_fe/                 ← React Frontend
    ├── src/
    │   ├──  components/
    │   │   ├── ComplaintForm.jsx   ← Add Complaint Form
    │   │   ├── ComplaintItem.jsx   ← Single Complaint Card
    │   │   └── ComplaintList.jsx   ← List of Complaints
    │   ├──  pages/
    │   │   ├── Dashboard.jsx       ← Summary + Complaints
    │   │   └── ApplyComplaint.jsx  ← Submit Complaint Page
    │   ├──  services/
    │   │   └── complainService.js  ← API Calls
    │   ├── App.jsx
    │   ├── App.css
    │   └── main.jsx
    └── package.json
```

---

##  Features

| Feature               | Description 
|-----------------------|------------------------------------------------------------------
|  Submit Complaint     | Users can submit complaints with name, title, description 
|  Assign Technician    | Admin can assign a technician to OPEN complaints 
|  Close Complaint      | Technician can close IN_PROGRESS complaints 
|  Dashboard            | Summary cards showing Total, Open, In Progress, Closed 
|  Filter               | Filter complaints by status 
|  Role Based Access    | Admin, Technician, User roles 
|  Dark Theme           | Modern dark UI design 

---

##  Complaint Lifecycle
```
┌─────────┐     Admin assigns      ┌─────────────┐     Technician closes    ┌──────────┐
│  OPEN   │ ──────────────────────▶│ IN_PROGRESS │ ───────────────────────▶│  CLOSED  │
└─────────┘     technician         └─────────────┘                          └──────────┘
```

### Status Rules

-  `OPEN` → `IN_PROGRESS` (Admin assigns technician)
-  `IN_PROGRESS` → `CLOSED` (Technician closes)
-  `OPEN` → `CLOSED` (Not allowed - must assign first)
-  `CLOSED` → any (Cannot modify closed complaints)

---

##  API Endpoints

`GET` --> `/api/complaints` --> Get all complaints 
`POST`--> `/api/complaints` --> Create new complaint 
`GET` --> `/api/complaints/{id}` --> Get complaint by ID 
`PUT` --> `/api/complaints/{id}/assign?technician=name` --> Assign technician 
`PUT` --> `/api/complaints/{id}/status?status=CLOSED` --> Update status 

---

##  How To Run

### Prerequisites

- Java 17+
- Node.js 18+
- Maven

---

###  Backend Setup

```bash

# Step 1: Go to backend folder
cd fixflow

# Step 2: Run Spring Boot
./mvnw spring-boot:run
```

 Backend runs on: `http://localhost:8080`

> H2 Console available at: `http://localhost:8080/h2-console`
> - JDBC URL: `jdbc:h2:mem:fixflowdb`
> - Username: `sa`
> - Password: 

---

###  Frontend Setup

```bash

# Step 1: Go to frontend folder
cd fixflow_fe

# Step 2: Install dependencies
npm install

# Step 3: Start development server
npm run dev
```

 Frontend runs on: `http://localhost:5173`

---

###  Run Order
```
1.  Start Backend  →  http://localhost:8080
2.  Start Frontend →  http://localhost:5173
3. Open Browser   →  http://localhost:5173
```

---

##  Pages

Dashboard --> `/` --> Summary cards + All complaints 
Apply Complaint --> `/apply` --> Submit new complaint form 

---

##  Roles

 USER --> Submit complaints, View complaints 
 ADMIN --> Assign technicians to OPEN complaints 
 TECHNICIAN --> Close IN_PROGRESS complaints 

---

##  Developer

**S.Muthuprakash**
-  Full Stack Java Developer
-  Project: FixFlow Complaint Management System
-  Built with Spring Boot + React

---

##  License

This project is for educational purposes.

---

 If you found this helpful, give it a star!

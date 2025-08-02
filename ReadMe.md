# 👨‍💼 Emplyfi – Employee Management System

Emplyfi is a full-stack Employee Management System that lets you manage employee records in a simple and clean interface. It's built using **Spring Boot**, **React**, and **Bootstrap**. You can add, update, delete, and view employee details from a responsive web app.

---

## 🔧 Tech Stack

- 💻 **Frontend**: React.js + Bootstrap 5
- 🚀 **Backend**: Spring Boot (Spring Web, Spring Data JPA)
- 🗄️ **Database**: MySQL
- 🧪 **Tools**: Postman, IntelliJ IDEA, VS Code

---

## ✨ Features

- ➕ Add new employee
- 📝 Edit employee details
- ❌ Delete employee
- 📄 View all employee records in a table
- 🔍 Search by name or department
- 📱 Mobile responsive design

---

## 🖥️ Getting Started

### ✅ Prerequisites

- Node.js & npm
- Java 17+
- MySQL installed and running

---

### 📦 Backend Setup (Spring Boot)

1. Navigate to the backend folder:

```bash
cd emplyfi/backend
```

2. Open the project in Ecclipse,IntelliJ or your preferred IDE.

3. Update your database details in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/emplyfi_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

4. Run the backend:

```bash
./mvnw spring-boot:run
```

---

### 🌐 Frontend Setup (React)

1. Navigate to the frontend folder:

```bash
cd ../frontend
```

2. Install dependencies:

```bash
npm install
```

3. Start the frontend:

```bash
npm start
```

> React app runs on: `http://localhost:3000`  
> Spring Boot backend runs on: `http://localhost:8080`

---

## 📂 Project Structure

```
emplyfi/
├── backend/       # Spring Boot backend
│   └── src/
│       └── main/java/com/emplyfi
├── frontend/      # React frontend
│   └── src/
│       ├── components/
│       └── pages/
```

---

## 🌱 Future Improvements

- 🔐 Add login system (JWT-based)
- 👥 Role-based access (Admin/User)
- 📊 Export employee data (CSV, PDF)
- 📌 Pagination and filtering
- 📈 Dashboard with charts

---

## 🤝 Contributing

If you'd like to improve something or add a new feature, feel free to fork the repo, make changes, and submit a pull request!

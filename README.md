# 🏍️ Motorbike Service Booking System

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue.svg)
![AI](https://img.shields.io/badge/AI-Gemini-purple.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status](https://img.shields.io/badge/Status-Active-success.svg)

**Backend API thông minh được xây dựng trên Spring Boot, cung cấp dịch vụ đặt lịch sửa chữa xe máy với AI Gemini hỗ trợ chẩn đoán và tối ưu hóa lịch hẹn.**

[English](#english-version) | [Demo](#-demo) | [Báo Lỗi](https://github.com/longvuvn/motorbike-service-booking/issues) | [Yêu Cầu Tính Năng](https://github.com/longvuvn/motorbike-service-booking/issues)

</div>

---

## 📋 Mục Lục

- [Giới Thiệu](#-giới-thiệu)
- [Tính Năng Nổi Bật](#-tính-năng-nổi-bật)
- [Công Nghệ Sử Dụng](#-công-nghệ-sử-dụng)
- [Kiến Trúc Hệ Thống](#-kiến-trúc-hệ-thống)
- [Demo](#-demo)
- [Hướng Dẫn Cài Đặt](#-hướng-dẫn-cài-đặt)
- [Cấu Hình](#-cấu-hình)
- [Sử Dụng API](#-sử-dụng-api)
- [Tích Hợp AI](#-tích-hợp-ai)
- [Đóng Góp](#-đóng-góp)
- [Giấy Phép](#-giấy-phép)
- [Liên Hệ](#-liên-hệ)

---

## 🎯 Giới Thiệu

**Motorbike Service Booking System** là một nền tảng đặt lịch dịch vụ sửa chữa xe máy hiện đại, tích hợp trí tuệ nhân tạo Gemini để chẩn đoán sự cố và đề xuất dịch vụ phù hợp. Hệ thống giúp kết nối khách hàng với các tiệm sửa chữa xe máy một cách nhanh chóng, hiệu quả và thông minh.

### 🌟 Điểm Nổi Bật

- ✅ **AI-Powered Diagnosis** - Chẩn đoán sự cố xe máy bằng Gemini AI
- ✅ **Smart Scheduling** - Tối ưu hóa lịch hẹn thông minh
- ✅ **RESTful API** hoàn chỉnh với Swagger/OpenAPI documentation
- ✅ **Bảo mật cao** với JWT Authentication & Spring Security
- ✅ **Cloud Integration** - Upload ảnh với Cloudinary
- ✅ **Microservices Ready** - Spring Cloud LoadBalancer
- ✅ **Real-time Monitoring** - Spring Boot Actuator

---

## ✨ Tính Năng Nổi Bật

### 🤖 AI & Chẩn Đoán Thông Minh
- 🧠 **AI Diagnosis** - Chẩn đoán sự cố xe máy qua Gemini AI
- 💡 **Service Recommendation** - Đề xuất dịch vụ phù hợp tự động
- 📊 **Smart Insights** - Phân tích dữ liệu đặt lịch thông minh
- 🎯 **Scheduling Optimization** - Tối ưu thời gian hẹn dựa trên AI

### 📅 Quản Lý Đặt Lịch
- ➕ **Booking Management** - Tạo, sửa, xóa lịch hẹn
- 📝 **Service Selection** - Chọn nhiều dịch vụ trong một lần đặt
- ⏰ **Real-time Status** - Theo dõi trạng thái lịch hẹn theo thời gian thực
- 🔔 **Status Updates** - Cập nhật trạng thái: Pending, Confirmed, Cancelled

### 🛠️ Quản Lý Dịch Vụ
- 📋 **Service CRUD** - Quản lý danh sách dịch vụ sửa chữa
- 🏷️ **Category Management** - Phân loại dịch vụ theo danh mục
- 💰 **Dynamic Pricing** - Giá linh hoạt (min-max)
- ⏱️ **Duration Estimation** - Ước tính thời gian thực hiện
- 🖼️ **Image Upload** - Upload ảnh dịch vụ lên Cloudinary
- 🔍 **Search & Filter** - Tìm kiếm và lọc dịch vụ

### 👥 Quản Lý Khách Hàng
- 🔐 **Authentication** - Đăng ký/đăng nhập với JWT
- 👤 **Customer Profile** - Quản lý thông tin cá nhân
- 📍 **Address Management** - Quản lý nhiều địa chỉ
- 📚 **Booking History** - Lịch sử đặt lịch
- 📦 **Order History** - Lịch sử đơn hàng

### 💳 Quản Lý Hóa Đơn & Thanh Toán
- 🧾 **Invoice Generation** - Tạo hóa đơn tự động
- 💵 **Payment Methods** - Nhiều phương thức thanh toán
- 📊 **Invoice Status** - Theo dõi trạng thái hóa đơn
- 🔗 **Booking-Invoice Link** - Liên kết lịch hẹn với hóa đơn

### 🛒 Quản Lý Sản Phẩm & Đơn Hàng
- 🛍️ **Product Management** - Quản lý phụ tùng, sản phẩm
- 📦 **Order Processing** - Xử lý đơn hàng
- 📈 **Inventory Tracking** - Theo dõi tồn kho

### 🔧 Tính Năng Kỹ Thuật
- 📄 **Pagination** - Phân trang cho tất cả danh sách
- 🔍 **Advanced Search** - Tìm kiếm nâng cao
- 📊 **Data Auditing** - Tự động ghi nhận thời gian tạo/cập nhật
- 🛡️ **Global Exception Handling** - Xử lý lỗi toàn cục
- ✅ **Data Validation** - Validation dữ liệu đầy đủ

---

## 🛠️ Công Nghệ Sử Dụng

<table>
<tr>
<td>

### Backend Framework
- **Spring Boot** `4.0.1`
- **Spring Security** - Bảo mật
- **Spring Data JPA** - Truy xuất dữ liệu
- **Spring Cloud** - Microservices
- **Spring Actuator** - Monitoring

</td>
<td>

### Database & ORM
- **PostgreSQL** `15+`
- **Hibernate** - ORM Framework
- **JPA** - Data persistence
- **HikariCP** - Connection pooling

</td>
</tr>
<tr>
<td>

### Security & Authentication
- **JWT (JJWT)** `0.13.0` - Token-based auth
- **Spring Security** - Authorization
- **BCrypt** - Password encryption
- **Refresh Token** - Session management

</td>
<td>

### AI & Cloud Services
- **Google Gemini AI** - AI diagnosis
- **Cloudinary** `1.39.0` - Image upload
- **Spring Cloud LoadBalancer** - Load balancing
- **RestTemplate** - HTTP client

</td>
</tr>
<tr>
<td>

### Documentation & Tools
- **SpringDoc OpenAPI** `2.8.3`
- **Swagger UI** - API Documentation
- **Lombok** - Code reduction
- **ModelMapper** `3.2.4` - DTO mapping
- **Gson** - JSON processing

</td>
<td>

### Development Tools
- **Spring DevTools** - Hot reload
- **Maven** - Build tool
- **Java** `17` - Programming language
- **Git** - Version control

</td>
</tr>
<tr>
<td>

### Testing
- **Spring Boot Test**
- **Spring Security Test**
- **JPA Test**
- **JUnit** - Unit testing

</td>
<td>

### Monitoring & DevOps
- **Spring Actuator** - Health checks
- **Logging** - SLF4J & Logback
- **Validation** - Bean Validation (JSR-380)

</td>
</tr>
</table>

---

## 🏗️ Kiến Trúc Hệ Thống

```
back-end/motorbike-be/
│
├── 📁 config/                         # Cấu hình ứng dụng
│   ├── SecurityConfig.java            # Bảo mật & JWT
│   ├── ModelMapperConfig.java         # DTO mapping configuration
│   ├── GeminiConfig.java              # Gemini AI configuration
│   ├── CloudinaryConfig.java          # Cloudinary configuration
│   └── JWTFilter.java                 # JWT authentication filter
│
├── 📁 controllers/                    # REST API Controllers
│   ├── AuthController                 # Authentication endpoints
│   ├── BookingController              # Booking management
│   ├── ServiceController              # Service management
│   ├── CustomerController             # Customer management
│   ├── InvoiceBookingController       # Invoice management
│   ├── OrderController                # Order management
│   ├── GeminiController               # AI diagnosis endpoints
│   └── ProductController              # Product management
│
├── 📁 services/                       # Business Logic Layer
│   ├── BookingService                 # Booking business logic
│   ├── ServiceService                 # Service business logic
│   ├── CustomerService                # Customer business logic
│   ├── InvoiceBookingService          # Invoice business logic
│   ├── GeminiService                  # AI integration logic
│   ├── CloudinaryService              # Image upload logic
│   └── impl/                          # Service implementations
│
├── 📁 repositories/                   # Data Access Layer
│   ├── BookingRepository              # Booking data access
│   ├── ServiceRepository              # Service data access
│   ├── CustomerRepository             # Customer data access
│   ├── InvoiceRepository              # Invoice data access
│   └── ...                            # Other repositories
│
├── 📁 models/                         # Domain Models
│   ├── User.java                      # Base user entity
│   ├── Customer.java                  # Customer entity
│   ├── Booking.java                   # Booking entity
│   ├── Services.java                  # Service entity
│   ├── Invoice.java                   # Invoice entity
│   ├── InvoiceBooking.java            # Invoice-Booking relationship
│   ├── BookingService.java            # Booking-Service relationship
│   ├── Order.java                     # Order entity
│   ├── Product.java                   # Product entity
│   ├── CategoryService.java           # Service category
│   ├── Address.java                   # Customer address
│   ├── RefreshToken.java              # Refresh token entity
│   └── Auditing.java                  # Base audit entity
│
├── 📁 dto/                            # Data Transfer Objects
│   ├── booking/                       # Booking DTOs
│   │   ├── request/                   # Request DTOs
│   │   └── response/                  # Response DTOs
│   ├── service/                       # Service DTOs
│   ├── customer/                      # Customer DTOs
│   ├── invoice/                       # Invoice DTOs
│   ├── gemini/                        # AI request/response DTOs
│   │   ├── DiagnosisRequest           # AI diagnosis request
│   │   ├── DiagnosisResponse          # AI diagnosis response
│   │   ├── InsightRequest             # Smart insights request
│   │   └── InsightResponse            # Smart insights response
│   └── response/                      # Common response wrapper
│       └── ApiResponse.java           # Standard API response
│
├── 📁 enums/                          # Enumerations
│   ├── BookingStatus                  # PENDING, CONFIRMED, CANCELLED
│   ├── InvoiceStatus                  # PAID, UNPAID, CANCELLED
│   ├── ServiceStatus                  # ACTIVE, INACTIVE
│   ├── CategoryStatus                 # ACTIVE, INACTIVE
│   ├── OrderStatus                    # PENDING, PROCESSING, COMPLETED
│   └── UserStatus                     # ACTIVE, INACTIVE, BLOCKED
│
├── 📁 utils/                          # Utility Classes
│   └── JWTUtil.java                   # JWT helper methods
│
└── 📁 resources/
    ├── application.yml                # Application configuration
    ├── banner.txt                     # Custom Spring Boot banner
    └── insert.sql                     # Initial data script
```

### 🔄 Request Flow
```
Client Request
    ↓
JWT Filter (Authentication)
    ↓
Security Filter Chain (Authorization)
    ↓
Controller (REST Endpoints)
    ↓
Service Layer (Business Logic + AI Integration)
    ↓
Repository (Data Access)
    ↓
PostgreSQL Database
    ↓
External Services (Gemini AI / Cloudinary)
```

### 🤖 AI Integration Flow
```
User Input (Symptoms/Problems)
    ↓
GeminiController
    ↓
GeminiService
    ↓
[Build Prompt with Context]
    ↓
Gemini AI API (Google)
    ↓
[Parse AI Response]
    ↓
DiagnosisResponse / InsightResponse
    ↓
Return to Client
```

---

## 📸 Demo

### 🖥️ Swagger API Documentation
<!-- Để trống cho người dùng tự điền -->
```
Thêm ảnh Swagger UI tại đây
```

### 🏍️ Booking Interface
<!-- Để trống cho người dùng tự điền -->
```
Thêm ảnh giao diện đặt lịch tại đây
```

### 🤖 AI Diagnosis Feature
<!-- Để trống cho người dùng tự điền -->
```
Thêm ảnh tính năng AI chẩn đoán tại đây
```

### 📱 Mobile App Screenshots
<!-- Để trống cho người dùng tự điền -->
```
Thêm ảnh ứng dụng mobile (nếu có) tại đây
```

---

## 🚀 Hướng Dẫn Cài Đặt

### Yêu Cầu Hệ Thống

- ☑️ **Java Development Kit (JDK)** 17 hoặc cao hơn
- ☑️ **Maven** 3.8+ 
- ☑️ **PostgreSQL** 15+
- ☑️ **Git** (để clone repository)
- ☑️ **Gemini API Key** (Google AI)
- ☑️ **Cloudinary Account** (Image hosting)
- ☑️ **IDE**: IntelliJ IDEA / Eclipse / VS Code (khuyến nghị IntelliJ IDEA)

### Bước 1️⃣: Clone Repository

```bash
git clone https://github.com/longvuvn/motorbike-service-booking.git
cd motorbike-service-booking/back-end/motorbike-be
```

### Bước 2️⃣: Cài Đặt PostgreSQL Database

1. **Khởi động PostgreSQL Server**
2. **Tạo database mới:**

```sql
CREATE DATABASE motorbike_service_booking;
CREATE USER motorbike_admin WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE motorbike_service_booking TO motorbike_admin;
```

3. **Chạy script khởi tạo dữ liệu (optional):**
```bash
psql -U motorbike_admin -d motorbike_service_booking -f src/main/resources/insert.sql
```

### Bước 3️⃣: Cấu Hình Biến Môi Trường

Tạo file `.env` hoặc thiết lập biến môi trường:

```properties
# Database Configuration
DB_HOST=localhost
DB_PORT=5432
DB_NAME=motorbike_service_booking
DB_USERNAME=motorbike_admin
DB_PASSWORD=your_password

# JWT Configuration
JWT_SECRET_KEY=your-256-bit-secret-key-here-make-it-long-and-random
JWT_EXPIRATION=3600000
JWT_REFRESH_EXPIRATION=604800000

# Gemini AI Configuration
GEMINI_API_KEY=your-gemini-api-key-here
GEMINI_API_URL=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent

# Cloudinary Configuration
CLOUDINARY_CLOUD_NAME=your-cloud-name
CLOUDINARY_API_KEY=your-cloudinary-api-key
CLOUDINARY_API_SECRET=your-cloudinary-api-secret

# Server Configuration
SERVER_PORT=8080
```

### 📝 Lấy Gemini API Key

1. Truy cập [Google AI Studio](https://makersuite.google.com/app/apikey)
2. Tạo API key mới
3. Copy và paste vào biến môi trường `GEMINI_API_KEY`

### 📝 Lấy Cloudinary Credentials

1. Đăng ký tài khoản tại [Cloudinary](https://cloudinary.com/)
2. Vào Dashboard để lấy:
   - Cloud Name
   - API Key
   - API Secret
3. Paste vào các biến môi trường tương ứng

### Bước 4️⃣: Build & Run Application

#### Sử Dụng Maven Wrapper (Khuyến nghị)

**Windows:**
```bash
cd back-end\motorbike-be
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
cd back-end/motorbike-be
./mvnw clean install
./mvnw spring-boot:run
```

#### Sử Dụng Maven Trực Tiếp

```bash
cd back-end/motorbike-be
mvn clean install
mvn spring-boot:run
```

### Bước 5️⃣: Kiểm Tra Ứng Dụng

✅ Ứng dụng sẽ chạy tại: **http://localhost:8080**

✅ Swagger UI: **http://localhost:8080/swagger-ui/index.html**

✅ API Docs: **http://localhost:8080/v3/api-docs**

✅ Health Check: **http://localhost:8080/actuator/health**

---

## ⚙️ Cấu Hình

### Application Configuration (`application.yml`)

```yaml
server:
  port: 8080

spring:
  application:
    name: motorbike-service-booking
  
  datasource:
    url: jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    properties:
      hibernate:
        format_sql: true

jwt:
  secret: ${JWT_SECRET_KEY}
  expiration: ${JWT_EXPIRATION}
  refresh-expiration: ${JWT_REFRESH_EXPIRATION}

gemini:
  api-key: ${GEMINI_API_KEY}
  api-url: ${GEMINI_API_URL}

cloudinary:
  cloud-name: ${CLOUDINARY_CLOUD_NAME}
  api-key: ${CLOUDINARY_API_KEY}
  api-secret: ${CLOUDINARY_API_SECRET}

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
```

### Tùy Chỉnh Cấu Hình

#### Thay đổi Port Server
```yaml
server:
  port: 9090  # Đổi sang port khác
```

#### Tắt SQL Logging (Production)
```yaml
spring:
  jpa:
    show-sql: false
    properties:
      hibernate:
        format_sql: false
```

#### Điều chỉnh JWT Expiration
```yaml
jwt:
  expiration: 7200000       # 2 hours
  refresh-expiration: 1209600000  # 14 days
```

#### Điều chỉnh Hibernate DDL
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: validate  # hoặc: create, create-drop, update, none
```

---

## 📡 Sử Dụng API

### Authentication Endpoints

#### 🔐 Đăng Ký
```http
POST /api/v1/auth/register
Content-Type: application/json

{
  "fullName": "Nguyen Van A",
  "email": "nguyenvana@example.com",
  "password": "SecurePassword123",
  "phoneNumber": "0901234567"
}
```

#### 🔐 Đăng Nhập
```http
POST /api/v1/auth/login
Content-Type: application/json

{
  "email": "nguyenvana@example.com",
  "password": "SecurePassword123"
}
```

**Response:**
```json
{
  "statusCode": 200,
  "message": "Login successful",
  "data": {
    "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "tokenType": "Bearer",
    "expiresIn": 3600
  },
  "error": null
}
```

#### 🔄 Refresh Token
```http
POST /api/v1/auth/refresh
Content-Type: application/json

{
  "refreshToken": "your-refresh-token"
}
```

### Service Management

#### 📋 Lấy Danh Sách Dịch Vụ
```http
GET /api/v1/services?page=0&size=10
Authorization: Bearer {access_token}
```

**Response:**
```json
{
  "statusCode": 200,
  "message": "Get All Service Successful",
  "data": {
    "content": [
      {
        "id": "uuid-here",
        "serviceName": "Thay dầu động cơ",
        "description": "Thay dầu động cơ toàn phần với dầu nhớt chính hãng",
        "image": "https://res.cloudinary.com/xxx/image.jpg",
        "estimatedMinPrice": "150000",
        "estimatedMaxPrice": "250000",
        "estimatedDurationMinutes": "30",
        "categoryId": "uuid",
        "categoryName": "Bảo dưỡng định kỳ",
        "status": "ACTIVE",
        "createdAt": "2025-01-15T10:30:00Z",
        "updatedAt": "2025-01-15T10:30:00Z"
      }
    ],
    "currentPage": 0,
    "totalItems": 50,
    "totalPages": 5
  },
  "error": null
}
```

#### ➕ Tạo Dịch Vụ Mới
```http
POST /api/v1/services
Authorization: Bearer {access_token}
Content-Type: multipart/form-data

service: {
  "serviceName": "Sửa phanh xe máy",
  "description": "Kiểm tra và sửa chữa hệ thống phanh",
  "estimatedMinPrice": "200000",
  "estimatedMaxPrice": "500000",
  "estimatedDurationMinutes": "45",
  "categoryId": "uuid-here"
}
image: [file]
```

#### 🔍 Tìm Kiếm Dịch Vụ
```http
GET /api/v1/services/search?name=thay%20dầu&page=0&size=10
Authorization: Bearer {access_token}
```

### Booking Management

#### 📅 Tạo Booking Mới
```http
POST /api/v1/bookings
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "customerId": "customer-uuid",
  "bookingDate": "2025-01-20T14:00:00Z",
  "bookingServiceRequests": [
    {
      "serviceId": "service-uuid-1",
      "finalPrice": "200000"
    },
    {
      "serviceId": "service-uuid-2",
      "finalPrice": "150000"
    }
  ],
  "totalPrice": "350000",
  "note": "Xe bị rung lắc khi phanh"
}
```

**Response:**
```json
{
  "statusCode": 201,
  "message": "Create Booking Successful",
  "data": {
    "id": "booking-uuid",
    "customerId": "customer-uuid",
    "customerName": "Nguyen Van A",
    "bookingDate": "2025-01-20T14:00:00Z",
    "totalPrice": "350000",
    "status": "PENDING",
    "bookingServiceResponses": [
      {
        "id": "booking-service-uuid-1",
        "serviceId": "service-uuid-1",
        "serviceName": "Thay dầu phanh",
        "finalPrice": "200000"
      },
      {
        "id": "booking-service-uuid-2",
        "serviceId": "service-uuid-2",
        "serviceName": "Kiểm tra hệ thống phanh",
        "finalPrice": "150000"
      }
    ],
    "note": "Xe bị rung lắc khi phanh",
    "createdAt": "2025-01-15T10:45:00Z",
    "updatedAt": "2025-01-15T10:45:00Z"
  },
  "error": null
}
```

#### 📋 Lấy Danh Sách Booking của Khách Hàng
```http
GET /api/v1/bookings/{customerId}?page=0&size=10
Authorization: Bearer {access_token}
```

#### 🔄 Cập Nhật Trạng Thái Booking
```http
PUT /api/v1/bookings/{bookingId}
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "status": "CONFIRMED",
  "note": "Đã xác nhận lịch hẹn"
}
```

### Invoice Management

#### 🧾 Tạo Hóa Đơn
```http
POST /api/v1/invoice-booking
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "bookingIds": ["booking-uuid-1", "booking-uuid-2"],
  "totalPrice": "500000",
  "paymentMethod": "CASH",
  "status": "UNPAID"
}
```

#### 📋 Lấy Danh Sách Hóa Đơn
```http
GET /api/v1/invoice-booking
Authorization: Bearer {access_token}
```

---

## 🤖 Tích Hợp AI

### Gemini AI Integration

Hệ thống tích hợp Google Gemini AI để cung cấp 2 tính năng chính:

#### 1. 🔧 AI Diagnosis - Chẩn Đoán Sự Cố

API này giúp chẩn đoán sự cố xe máy dựa trên mô tả triệu chứng từ khách hàng.

```http
POST /api/diagnosis/motorbike
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "symptoms": "Xe bị rung lắc mạnh khi phanh, tiếng kêu cót két từ bánh trước",
  "motorbikeType": "Honda Wave Alpha 110",
  "mileage": "15000"
}
```

**Response:**
```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {
    "diagnosis": "Dựa trên các triệu chứng bạn mô tả, xe có thể gặp các vấn đề sau:\n\n1. **Má phanh mòn hoặc lỏng**: Tiếng kêu cót két và rung lắc khi phanh thường do má phanh đã mòn hoặc bị lỏng.\n\n2. **Đĩa phanh bị cong vênh**: Đĩa phanh bị biến dạng có thể gây ra rung lắc khi phanh.\n\n3. **Bạc đạn bánh trước bị hỏng**: Bạc đạn hỏng cũng có thể tạo ra tiếng kêu và rung lắc.\n\n**Khuyến nghị:**\n- Kiểm tra và thay má phanh nếu cần\n- Kiểm tra đĩa phanh, thay thế nếu bị cong\n- Kiểm tra bạc đạn bánh trước",
    "severity": "MEDIUM",
    "urgency": "SHOULD_FIX_SOON",
    "estimatedCost": "300000-800000",
    "recommendedServices": [
      {
        "serviceName": "Thay má phanh trước",
        "description": "Thay cặp má phanh trước mới chính hãng",
        "estimatedPrice": "200000-350000"
      },
      {
        "serviceName": "Kiểm tra và mài đĩa phanh",
        "description": "Kiểm tra độ phẳng đĩa phanh và mài nếu cần",
        "estimatedPrice": "100000-200000"
      },
      {
        "serviceName": "Kiểm tra bạc đạn bánh trước",
        "description": "Kiểm tra và thay bạc đạn nếu bị hỏng",
        "estimatedPrice": "150000-300000"
      }
    ]
  },
  "error": null
}
```

#### 2. 📊 Smart Scheduling Insights - Tối Ưu Lịch Hẹn

API này cung cấp thông tin thống kê và gợi ý thời gian đặt lịch tốt nhất.

```http
POST /api/diagnosis/insight
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "bookingDate": "2025-01-20",
  "serviceId": "service-uuid-here"
}
```

**Response:**
```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {
    "insight": "**Phân tích lịch hẹn cho ngày 20/01/2025:**\n\n- **Tình trạng:** Ngày này có 12 lịch hẹn đã được đặt\n- **Khung giờ bận:** 09:00-12:00 và 14:00-16:00\n- **Khung giờ khuyến nghị:** 08:00-09:00 hoặc 16:00-18:00\n\n**Dự báo:**\nDịch vụ này thường mất khoảng 45 phút. Trong 30 ngày qua, có 25 khách hàng đã sử dụng dịch vụ tương tự.\n\n**Gợi ý:**\n- Đặt lịch sớm (8:00-9:00) để tránh chờ đợi\n- Thứ 2 và Thứ 3 thường ít khách hơn Thứ 6",
    "recommendedTimeSlots": [
      "08:00-09:00",
      "16:00-17:00",
      "17:00-18:00"
    ],
    "busyTimeSlots": [
      "09:00-12:00",
      "14:00-16:00"
    ],
    "averageWaitTime": "15",
    "popularityScore": 85
  },
  "error": null
}
```

### Cấu Hình Gemini AI

**Trong `application.yml`:**
```yaml
gemini:
  api-key: ${GEMINI_API_KEY}
  api-url: https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent
  model: gemini-pro
  temperature: 0.7
  max-tokens: 2048
```

### Tùy Chỉnh AI Prompts

Bạn có thể tùy chỉnh prompts trong `GeminiService.java`:

```java
private String buildDiagnosisPrompt(DiagnosisRequest request) {
    return String.format(
        "Bạn là một chuyên gia sửa chữa xe máy với 20 năm kinh nghiệm. " +
        "Khách hàng đang gặp vấn đề sau:\n\n" +
        "Xe: %s\n" +
        "Số km đã đi: %s km\n" +
        "Triệu chứng: %s\n\n" +
        "Hãy chẩn đoán vấn đề và đề xuất giải pháp chi tiết.",
        request.getMotorbikeType(),
        request.getMileage(),
        request.getSymptoms()
    );
}
```

---

## 📖 Tài Liệu API Đầy Đủ

Truy cập **Swagger UI** để xem tài liệu API đầy đủ và test endpoints:

🔗 **http://localhost:8080/swagger-ui/index.html**

### API Response Format

Tất cả API đều trả về theo format chuẩn:

```json
{
  "statusCode": 200,
  "message": "Success message",
  "data": { /* response data */ },
  "error": null
}
```

**Error Response:**
```json
{
  "statusCode": 400,
  "message": "Error message",
  "data": null,
  "error": "Detailed error description"
}
```

---

## 🤝 Đóng Góp

Chúng tôi rất hoan nghênh mọi đóng góp! Dưới đây là quy trình đóng góp:

### 🌿 Quy Trình Đóng Góp

1. **Fork** repository này
2. **Clone** repository về máy local:
   ```bash
   git clone https://github.com/your-username/motorbike-service-booking.git
   ```
3. **Tạo branch mới** cho feature/bugfix:
   ```bash
   git checkout -b feature/amazing-feature
   ```
4. **Commit** thay đổi:
   ```bash
   git commit -m "Add some amazing feature"
   ```
5. **Push** lên branch:
   ```bash
   git push origin feature/amazing-feature
   ```
6. **Tạo Pull Request** trên GitHub

### 📝 Coding Standards

- ✅ Tuân thủ Java Code Conventions
- ✅ Viết Javadoc cho public methods
- ✅ Đảm bảo test cases pass
- ✅ Format code trước khi commit
- ✅ Viết commit message rõ ràng và có ý nghĩa
- ✅ Validate dữ liệu đầy đủ với Bean Validation
- ✅ Sử dụng DTO cho request/response
- ✅ Handle exceptions properly

### 🐛 Báo Lỗi

Nếu bạn phát hiện lỗi, vui lòng tạo **Issue** mới với:
- Mô tả chi tiết lỗi
- Các bước để reproduce
- Expected vs Actual behavior
- Screenshots/logs (nếu có)
- Environment (Java version, Database version, etc.)

### 💡 Đề Xuất Tính Năng

Để đề xuất tính năng mới:
- Mô tả tính năng chi tiết
- Giải thích use case
- Đề xuất implementation approach (optional)

---

## 📄 Giấy Phép

Dự án này được phân phối dưới giấy phép **MIT License**. Xem file [LICENSE](LICENSE) để biết thêm chi tiết.

```
MIT License

Copyright (c) 2025 Long Vu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 📞 Liên Hệ

<div align="center">

**Long Vu**

[![GitHub](https://img.shields.io/badge/GitHub-longvuvn-181717?style=for-the-badge&logo=github)](https://github.com/longvuvn)
[![Email](https://img.shields.io/badge/Email-Contact-D14836?style=for-the-badge&logo=gmail)](mailto:longvuvn@example.com)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0077B5?style=for-the-badge&logo=linkedin)](https://linkedin.com/in/longvuvn)

**Repository:** https://github.com/longvuvn/motorbike-service-booking

</div>

---

## 🙏 Acknowledgments

- Spring Boot Community
- Google Gemini AI Team
- Cloudinary Documentation
- PostgreSQL Community
- Spring Security Documentation
- Swagger/OpenAPI Community
- All contributors and testers

---

## 🔮 Future Enhancements

- [ ] **Real-time Notifications** - WebSocket cho thông báo real-time
- [ ] **Mobile App** - Ứng dụng mobile React Native / Flutter
- [ ] **Payment Gateway** - Tích hợp VNPay, MoMo, ZaloPay
- [ ] **Rating & Review System** - Đánh giá dịch vụ từ khách hàng
- [ ] **Advanced Analytics** - Dashboard thống kê chi tiết
- [ ] **Multi-language Support** - Hỗ trợ đa ngôn ngữ
- [ ] **Email Notifications** - Gửi email tự động
- [ ] **SMS Notifications** - Gửi SMS nhắc lịch hẹn
- [ ] **QR Code Check-in** - Check-in bằng QR code
- [ ] **Loyalty Program** - Chương trình khách hàng thân thiết

---

<div align="center">

### ⭐ Nếu dự án này hữu ích, đừng quên cho một Star! ⭐

**Made with ❤️ and 🤖 AI by Long Vu**

---

# English Version

</div>

## 📋 Table of Contents

- [Introduction](#-introduction-en)
- [Key Features](#-key-features-en)
- [Tech Stack](#️-tech-stack-en)
- [Architecture](#️-architecture-en)
- [Getting Started](#-getting-started-en)
- [API Usage](#-api-usage-en)
- [AI Integration](#-ai-integration-en)
- [Contributing](#-contributing-en)
- [License](#-license-en)

---

## 🎯 Introduction (EN)

**Motorbike Service Booking System** is a modern motorcycle service booking platform integrated with Gemini AI for intelligent diagnosis and service recommendations. The system efficiently connects customers with motorcycle repair shops in a fast, efficient, and smart way.

### 🌟 Highlights

- ✅ **AI-Powered Diagnosis** - Diagnose motorcycle issues using Gemini AI
- ✅ **Smart Scheduling** - Intelligent appointment optimization
- ✅ **Complete RESTful API** with Swagger/OpenAPI documentation
- ✅ **High Security** with JWT Authentication & Spring Security
- ✅ **Cloud Integration** - Image upload with Cloudinary
- ✅ **Microservices Ready** - Spring Cloud LoadBalancer
- ✅ **Real-time Monitoring** - Spring Boot Actuator

---

## ✨ Key Features (EN)

### 🤖 AI & Smart Diagnosis
- 🧠 **AI Diagnosis** - Diagnose motorcycle issues via Gemini AI
- 💡 **Service Recommendation** - Automatic service suggestions
- 📊 **Smart Insights** - Intelligent booking data analysis
- 🎯 **Scheduling Optimization** - AI-based time optimization

### 📅 Booking Management
- ➕ **Booking CRUD** - Create, update, delete appointments
- 📝 **Multi-Service Selection** - Select multiple services per booking
- ⏰ **Real-time Status** - Track booking status in real-time
- 🔔 **Status Updates** - Status: Pending, Confirmed, Cancelled

### 🛠️ Service Management
- 📋 **Service CRUD** - Manage repair service list
- 🏷️ **Category Management** - Service categorization
- 💰 **Dynamic Pricing** - Flexible pricing (min-max)
- ⏱️ **Duration Estimation** - Estimated completion time
- 🖼️ **Image Upload** - Upload service images to Cloudinary
- 🔍 **Search & Filter** - Search and filter services

### 👥 Customer Management
- 🔐 **Authentication** - Registration/login with JWT
- 👤 **Customer Profile** - Personal information management
- 📍 **Address Management** - Multiple address management
- 📚 **Booking History** - Booking history tracking
- 📦 **Order History** - Order history tracking

---

## 🚀 Getting Started (EN)

### Prerequisites

- ☑️ **Java Development Kit (JDK)** 17 or higher
- ☑️ **Maven** 3.8+ 
- ☑️ **PostgreSQL** 15+
- ☑️ **Git**
- ☑️ **Gemini API Key** (Google AI)
- ☑️ **Cloudinary Account**

### Installation

#### Step 1: Clone Repository

```bash
git clone https://github.com/longvuvn/motorbike-service-booking.git
cd motorbike-service-booking/back-end/motorbike-be
```

#### Step 2: Setup PostgreSQL Database

```sql
CREATE DATABASE motorbike_service_booking;
CREATE USER motorbike_admin WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE motorbike_service_booking TO motorbike_admin;
```

#### Step 3: Configure Environment Variables

Create `.env` file:

```properties
DB_HOST=localhost
DB_PORT=5432
DB_NAME=motorbike_service_booking
DB_USERNAME=motorbike_admin
DB_PASSWORD=your_password

JWT_SECRET_KEY=your-256-bit-secret-key
JWT_EXPIRATION=3600000
JWT_REFRESH_EXPIRATION=604800000

GEMINI_API_KEY=your-gemini-api-key
GEMINI_API_URL=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent

CLOUDINARY_CLOUD_NAME=your-cloud-name
CLOUDINARY_API_KEY=your-cloudinary-api-key
CLOUDINARY_API_SECRET=your-cloudinary-api-secret
```

#### Step 4: Build & Run

**Windows:**
```bash
cd back-end\motorbike-be
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
cd back-end/motorbike-be
./mvnw clean install
./mvnw spring-boot:run
```

#### Step 5: Access Application

- **Application:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui/index.html
- **API Docs:** http://localhost:8080/v3/api-docs
- **Health Check:** http://localhost:8080/actuator/health

---

## 📡 API Usage (EN)

### Authentication

#### Register
```http
POST /api/v1/auth/register
Content-Type: application/json

{
  "fullName": "John Doe",
  "email": "john@example.com",
  "password": "SecurePass123",
  "phoneNumber": "0901234567"
}
```

#### Login
```http
POST /api/v1/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "SecurePass123"
}
```

### AI Diagnosis

#### Diagnose Motorbike Problem
```http
POST /api/diagnosis/motorbike
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "symptoms": "Bike shakes when braking, squeaking noise from front wheel",
  "motorbikeType": "Honda Wave Alpha 110",
  "mileage": "15000"
}
```

#### Get Scheduling Insights
```http
POST /api/diagnosis/insight
Authorization: Bearer {access_token}
Content-Type: application/json

{
  "bookingDate": "2025-01-20",
  "serviceId": "service-uuid-here"
}
```

### 📖 Full API Documentation

Visit **Swagger UI** for complete API documentation:

🔗 **http://localhost:8080/swagger-ui/index.html**

---

## 🤝 Contributing (EN)

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Coding Standards

- ✅ Follow Java Code Conventions
- ✅ Write Javadoc for public methods
- ✅ Ensure all tests pass
- ✅ Format code before committing
- ✅ Write clear and meaningful commit messages

---

## 📄 License (EN)

This project is licensed under the **MIT License**. See [LICENSE](LICENSE) file for details.

---

<div align="center">

**⭐ Star this repository if you find it helpful! ⭐**

**Made with ❤️ and 🤖 AI by Long Vu**

[![GitHub followers](https://img.shields.io/github/followers/longvuvn?style=social)](https://github.com/longvuvn)
[![GitHub stars](https://img.shields.io/github/stars/longvuvn/motorbike-service-booking?style=social)](https://github.com/longvuvn/motorbike-service-booking/stargazers)

</div>

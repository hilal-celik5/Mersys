# 📘 Mersys Student Information System

## 📌 Project Description

This project is a comprehensive student information system that offers a wide range of services, from allowing students
to log into the system, view course schedules, track their assignments, to managing their financial transactions.

## 🧩 User Stories and Features

### 1. 🛡️ Login and Profile Management

- **US-001: Student Login**
    - As a student, I want to be able to log into the system. *(Feature: Login)*
- **US-002: Access Home Page**
    - I want to return to the home page by clicking the logo. *(Feature: HomeFromLogo)*
- **US-003: Menu Navigation**
    - All buttons in the top menu should work correctly. *(Feature: HomeMainNavigation)*

### 2. 📩 Messaging System

- **US-004:** I want to be able to view my messages from the hamburger menu. *(Feature: MessagingMenu)*
- **US-005:** I want to send messages. *(Feature: MessagingSend)*
- **US-006:** I want to delete messages from my outbox. *(Feature: MessagingDeleteOutbox)*
- **US-007:** I want to be able to restore deleted messages or permanently delete them. *(Feature:
  MessagingRestoreDelete)*

### 3. 💳 Financial Transactions

- **US-008:** I want to access the finance section and make payments. *(Feature: FinanceAccess)*
- **US-009:** I want to see installment details. *(Feature: FinanceInstallmentView)*
- **US-010:** I want to view the remaining debt after making a payment. *(Feature: FinanceBalanceUpdate)*
- **US-011:** I want to make a $235 payment via Stripe. *(Feature: FinanceStripePayment)*
- **US-012:** I want to download my payment information as Excel or PDF. *(Feature: FinanceDownloadReport)*

### 4. 📅 Calendar and Course Management

- **US-013:** I want to submit excuse requests. *(Feature: AttendanceExcuse)*
- **US-014:** I want to upload a profile picture. *(Feature: ProfilePictureUpload)*
- **US-015:** I want to select a theme color. *(Feature: ProfileThemeChange)*
- **US-016:** I want to view my grades and transcript. *(Feature: GradingView)*
- **US-017:** I want to download my course notes and transcript to my device. *(Feature: GradingDownload)*

### 5. 📝 Assignment and Task Management

- **US-018:** I want to view tasks assigned to me. *(Feature: AssignmentViewTasks)*
- **US-019:** I want to start discussions on the assignments page. *(Feature: AssignmentStartDiscussion)*
- **US-020:** I want to perform quick actions from the assignment list. *(Feature: AssignmentQuickActions)*
- **US-021:** I want to upload assignments. *(Feature: SubmitHomework)*
- **US-022:** I want to search and sort tasks. *(Feature: AssignmentSearchSort)*

### 6. 📅 Calendar and Course Tracking

- **US-023:** I want to view and track the course schedule weekly/monthly. *(Feature: CalendarWeeklyView)*
- **US-024:** I should not be able to join courses that have not started. *(Feature: CalendarBlockUnstartedCourse)*
- **US-025:** I want to watch recordings of completed courses. *(Feature: CalendarAccessEndedRecordings)*

## Technologies and Tools Used

- **Java** - Programming language
- **Selenium** - Web browser automation
- **TestNG** - Testing framework.
- **Cucumber** - Behavior Driven Development (BDD) framework.
- **ExtentReports** - Reporting library.
- **Apache POI** - Library for reading and writing Excel files
- **Maven** - Dependency management and Build
- **Git & GitHub** - Version control Systems
- **JIRA & Zephyr Scale** - Test management Tools
- **Page Object Model (POM)** - Test Automation Pattern
- **Grasshopper** - HTML & PDF Report tool

## User Stories & Contributors

| Contributor                                          | Role                                  | User Stories                                   |
|------------------------------------------------------|---------------------------------------|------------------------------------------------|
| [Hilal ÇELİK](https://github.com/hilal-celik5)       | Project Lead & QA Automation Engineer | US-001, US-002, US-003, US-004, US-014, US-015 |
| [Telman BAYRAMOV](https://github.com/TELMAN-CREATOR) | QA Automation Engineer                | US-009, US-010, US-011, US-012, US-013         |
| [Mustafa İNAN](https://github.com/Mustafainan11)     | QA Automation Engineer                | US-005, US-006, US-007, US-008                 |
| [Mert GÖÇMEN](https://github.com/Mert-Gocmen)        | QA Automation Engineer                | US-016, US-017                                 |
| [Yiğithan DÜZGÜN](https://github.com/yigithanduzgun) | QA Automation Engineer                | US-018, US-019, US-020, US-021                 |
| [Görkem KEZER](https://github.com/Gorkem-Kezer)      | QA Automation Engineer                | US-022, US-023, US-024, US-025                 |

## License

This project is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT)
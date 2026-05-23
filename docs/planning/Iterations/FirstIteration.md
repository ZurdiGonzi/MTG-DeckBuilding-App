# First Iteration

## General Information
* **Duration:** 2 weeks
* **Primary Objective:** Establish the foundation of the system by setting up the database and creating the initial page mockups (views) in the frontend.

---

## Detailed Objectives

### 1. Database Setup
* Design and map the relational data model using **Spring Data JPA** and **Hibernate**.
* Configure the main entities (`User`, `Card`, `Deck`, `LinkedAccount`, etc.) and their relationships.
* Ensure initial database migrations and persistence function correctly.

### 2. View Mockups & Design (Frontend)
* Create the initial page mockups and layout designs for key pages in **native HTML/CSS**.
* These views will serve as static prototypes to define the visual layout and user experience (UX).
* **Future Migration:** The resulting HTML/CSS code will be clean and structured to easily migrate to **TSX (React / TypeScript)** components in the next phase.

---

## Task Plan (2 Weeks)

### Week 1: Backend & Database
* [ ] Finalize JPA entities design and their relationships in Java.
* [ ] Configure the local database and verify automatic table generation.
* [ ] Create basic repositories (`UserRepository`, `CardRepository`, etc.) and run initial persistence tests.

### Week 2: Frontend & HTML Prototyping
* [ ] Set up the directory structure for HTML/CSS mockups.
* [ ] Develop the home view and card catalog page in static HTML.
* [ ] Develop the user profile and creator/shop enrollment views in static HTML.
* [ ] Validate the visual design and prepare the code for TSX migration.

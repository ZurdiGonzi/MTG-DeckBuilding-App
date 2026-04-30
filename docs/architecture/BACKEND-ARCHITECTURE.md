# Software Architecture Document: MTG Platform

## 1. Introduction and Objectives

### 1.1. System Purpose

The purpose of this system is to provide a comprehensive platform for enthusiasts and content creators of the trading card game Magic: The Gathering (MTG). The application seeks to centralize the player experience by digitizing physical collections, managing strategic decks, fostering communities, and professionalizing creators through monetization tools. The system leverages the Spring Boot ecosystem to ensure a robust, secure, and scalable foundation capable of handling image processing for card scanning and secure financial transactions.

### 1.2. Project Scope

The platform is divided into four fundamental modules that define the functional scope of the system:

| Module                              | Description and Key Functionalities                                                                                                                                                                                         |
| :---------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Deck Management (Deckbuilder)**   | Tool for the creation, editing, and statistical analysis of decks (mana curve, card types). Integration with external APIs (Scryfall) for updated data. A functional AI will also be added to provide deck recommendations. |
| **Card Scanning (Computer Vision)** | Functionality to identify physical cards using the device's camera, allowing for bulk inventory uploads to the user's account.                                                                                              |
| **Communities and Groups**          | Social system to create small groups (friends) or large groups (stores or similar) where public cards and decks of each community user can be accessed. Tournament management and similar activities can also be handled.   |
| **Monetization for Creators**       | Creators will be able to create paid decks that can only be accessed if the user has paid or is subscribed to the creator.                                                                                                  |

---

### 1.3. Quality Objectives (Quality Attributes)

To ensure the technical success of the Spring Boot application, the following priority objectives are established:

- **Scalability**: The backend must be capable of handling load spikes during new MTG expansion launches through the use of microservices or containers.
- **Availability**: Guarantee an uptime of 99.9% for payment services and access to creator content.
- **Security**: Strict implementation of OAuth2 and JWT to protect financial information and user data.
- **Performance**:
  - Card scanning must provide results in less than 2 seconds to ensure a good user experience (UX).
  - Card searching must return results in less than 2 seconds.
  - AI-generated deck assistance must provide results in less than 10 seconds.
  - Content loading must provide results in less than 2 seconds.

## 2. System Context

### 2.1. Stakeholders and Actors

- **Unregistered User (Guest)**: Can browse public content, search for cards, and view public decks or profiles.
- **Registered User**: Can create unlimited decks, manage their personal card collection, join/create small groups (friends), use AI tools with standard limits, and subscribe to creators or premium content.
- **Creator User**: Can publish paid-access decks and access unlimited AI assistance features, in addition to standard registered user functionalities.
- **Store / LGS (Local Game Store)**: Can organize official tournaments, manage large community groups, and maintain a digital inventory of cards for local availability.
- **Moderator**: Assists administrators by handling community reports, moderating group content, and ensuring platform guidelines are followed.
- **Administrator**: Has exclusive access to the management dashboard to handle high-level moderation (banning, role assignment) and system-wide configurations.

### 2.2. Integrations

- **Scryfall API**: The primary source for card data, high-resolution images, and legality information. It is used for card identification, search functionality, and as the knowledge base for the AI.
- **Groq (Llama 3)**: High-performance AI inference engine used for deck-building assistance while proprietary AI is under development. Ensures response times stay under 10 seconds.
- **OpenCV**: Computer vision library used for real-time card detection and image processing during the scanning process.
- **Stripe Connect**: Secure payment infrastructure for processing creator subscriptions, deck purchases, and transactions.
- **Supabase (PostgreSQL)**: Relational database providing scalable storage and high-performance indexing for card data and user collections.
- **Spring Security**: Framework for authentication and authorization, utilizing JWT and BCrypt for secure industry-standard credential management.

## 3. Architectural Patterns

### 3.1. Layered Architecture (N-Tier)

The backend follows a standard Spring Boot layered architecture to ensure separation of concerns:

- **Presentation Layer (Controllers)**: RESTful APIs handling HTTP requests, input validation, and HTTP responses.
- **Business Logic Layer (Services)**: Core business rules, AI integration logic (Groq), external API calls (Scryfall), and payment processing (Stripe).
- **Data Access Layer (Repositories)**: Spring Data JPA interfaces managing database interactions with Supabase.

### 3.2. Desacoplamiento de Servicios Críticos:

To handle high-compute processes such as Computer Vision and AI, the architecture will implement an asynchronous processing pattern. Resource-heavy tasks will be offloaded to independent workers or specialized Python microservices, ensuring the main Spring Boot execution thread remains non-blocking and responsive.

## 4. Data Architecture (Core Entities)

- **User**: Core entity handling authentication, roles (Admin, Moderator, Creator, Registered), and profile data.
- **Card**: Local cache of Scryfall data to optimize search queries and reduce external API dependency.
- **Deck**: Represents a collection of cards, linked to a User.
- **Community/Group**: Entities managing social features, store profiles, and tournament organization.
- **Subscription**: Entities that link users to their active subscriptions or premium access.

## 5. API Design Overview

- `/api/v1/auth/**`: Endpoints for login, registration, and JWT token management.
- `/api/v1/decks/**`: CRUD operations for deck management and AI recommendations.
- `/api/v1/cards/**`: Card search, filtering, and computer vision scanning endpoints.
- `/api/v1/community/**`: Group management and social interactions.

## 6. Security Architecture

- **Authentication**: Stateless authentication using JWT (JSON Web Tokens).
- **Authorization**: Role-Based Access Control (RBAC) utilizing Spring Security to restrict access based on user types.
- **Data Protection**: BCrypt password hashing and HTTPS/TLS for all data in transit.

## 7. Deployment Strategy (Future Scope)

- **Containerization**: Docker to ensure consistent environments across development and production.
- **CI/CD**: GitHub Actions for automated testing, build verification, and deployment.
- **SupaBase**: Cloud storage solution for user-uploaded assets and scanned card artifacts.

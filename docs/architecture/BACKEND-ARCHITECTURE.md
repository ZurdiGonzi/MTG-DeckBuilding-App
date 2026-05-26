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

### 3.1. Clean Architecture (Ports & Adapters)

The backend follows **Clean Architecture** (specifically the Ports & Adapters / Hexagonal pattern), which was chosen as the best architectural design for the long term to ensure decoupling, ease of testing, and flexibility in changing external dependencies.

The system is organized into the following layers:

- **Domain Layer (Core)**:
  - **Models/Entities**: Contains the core business domain models (e.g., `User`, `Card`, `Deck`) completely independent of any frameworks, libraries, or database specifics.
  - **Ports**: Inbound and outbound interfaces.
    - *Inbound Ports (Use Cases / Input Ports)*: Define the application interfaces that drive business logic.
    - *Outbound Ports (Output Ports / SPIs)*: Define interfaces for infrastructure needs (e.g., database persistence like `UserRepositoryPort`, external APIs, etc.).
- **Infrastructure Layer (Adapters)**:
  - **Inbound Adapters (REST Controllers / Presenters)**: Translate external inputs (e.g., HTTP REST requests) into domain commands via inbound ports.
  - **Outbound Adapters (Infrastructure Implementations)**: Implement outbound ports to connect with external services, including Spring Data JPA database operations (Supabase), Scryfall client, Groq client, and Stripe API wrapper.

### 3.2. Critical Services Decoupling:

To handle high-compute processes such as Computer Vision and AI, the architecture will implement an asynchronous processing pattern. Resource-heavy tasks will be offloaded to independent workers or specialized Python microservices, ensuring the main Spring Boot execution thread remains non-blocking and responsive.

## 4. Design Patterns

Specific design patterns are implemented to ensure the system remains maintainable, extensible, and resilient when interacting with external services and complex game rules.

### 4.1. Adapter

- **Location**: Infrastructure / Integration Layer (com.mtgplatform.infrastructure.adapters).
- **Purpose**: To standardize interfaces for external services such as Scryfall (card data) and Stripe (payments).
- **Justification**: This decouples the core business logic from third-party proprietary data models. If the card data provider or payment gateway changes in the future, only a new adapter needs to be implemented without modifying the system's core.

### 4.2. Strategy

- **Location**: Deckbuilder Module (com.mtgplatform.service.deck.validation).
- **Purpose**: To manage varying legality rules based on game formats (e.g., Commander, Standard, Modern).
- **Justification**: Instead of using bloated if/else or switch blocks to validate a deck, each format's rule set is encapsulated in an independent strategy class. This allows for the modular addition of new game formats.

### 4.3. Observer

- **Location**: Community and Notification Module (com.mtgplatform.service.community.events).
- **Purpose**: To notify followers or subscribers whenever a creator publishes new content or a premium deck.
- **Justification**: Maintains minimal coupling between the content creation service and the notification system (push, email, in-app alerts). The creation service simply emits an event, and subscribers react automatically.

### 4.4. Circuit Breaker

- **Location**: AI and Computer Vision Integration Layer (com.mtgplatform.infrastructure.resilience).
- **Purpose**: To handle failures or excessive latency in Groq (Llama 3) or the Python (OpenCV) microservice.
- **Justification**: Utilizing Resilience4j, the system can "trip the circuit" if an AI service fails repeatedly. This prevents Spring Boot execution threads from hanging and allows the system to provide a fallback response, maintaining overall platform stability.

### 4.5. Factory Method

- **Location**: Card Domain (com.mtgplatform.domain.factory).
- **Purpose**: To centralize the creation of Card objects from diverse sources (API data, image scanning results, or manual user input).
- **Justification**: Ensures that every card object created undergoes initial business validation and correct type mapping before entering the Deckbuilder logic or being persisted in the database.

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

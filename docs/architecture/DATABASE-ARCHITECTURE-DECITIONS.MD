# Architecture Summary: Unified Identity & Auth

## The Problem
I needed to integrate multiple authentication providers (Google, Patreon, etc.) without polluting my core `User` entity or creating a "Sparse Table" (a database table filled with mostly null values). I also faced a mismatch between protocols: Google provides identity via OIDC tokens, while Patreon requires an additional API call to resolve identity via OAuth2.

## The Solution: The "LinkedAccount" Pattern
I implemented a JPA `SINGLE_TABLE` Inheritance strategy to decouple identity from authentication.

* **Decoupling:** `User` remains the central profile, while `LinkedAccount` acts as a technical "keychain" for third-party credentials.
* **Polymorphism:** All providers inherit from an abstract `LinkedAccount` class. This allows me to handle tokens (`access_token`, `refresh_token`, `expires_at`) uniformly for every provider.
* **Scalability:** Adding a new provider (e.g., Discord) now requires only a new entity class, with no changes to the existing database schema or the `User` entity.
* **Tech Stack:** I used JPA/Hibernate for mapping and Lombok’s `@SuperBuilder` to manage class hierarchies cleanly without boilerplate code.

## Risk Management

### Database Constraints
* **Issue:** `SINGLE_TABLE` inheritance prevents native `NOT NULL` constraints on provider-specific IDs.
* **Mitigation:** Enforcement is handled by logic in the Service Layer prior to persistence.

### Infinite Loops
* **Issue:** Bidirectional relationships between `User` and `LinkedAccount` can cause a `StackOverflowError` via Lombok's generated methods.
* **Mitigation:** Applied `@ToString.Exclude` and `@EqualsAndHashCode.Exclude` to break recursion.

### Transaction Management
* **Issue:** Lazy-loading associations often cause `LazyInitializationException`.
* **Mitigation:** All authentication service methods are wrapped in `@Transactional` to maintain context.

---

# Architecture Summary: Database & Relationship Design

## 1. Bidirectional Relationship Strategy
* **The Problem:** I had to decide whether to map the User <-> Deck relationship bidirectionally or remain strictly unidirectionally.
* **The Solution:** I opted for Bidirectional Mapping.
  * **Consistency:** By mapping both sides, I allow for seamless navigation (e.g., accessing all decks from a User profile or identifying the owner of a Deck).
  * **JPA Management:** I defined the User as the non-owning side using `mappedBy`, ensuring the relationship is managed by the Deck (the child).
  * **Convenience:** I implemented "Helper Methods" (e.g., addDeck) to synchronize both sides of the relationship in memory, preventing common data integrity issues.

## 2. Data Integrity & Risk Mitigation
* **Infinite Loops:** In bidirectional JPA relationships, standard `toString()` or `equals()` methods often cause `StackOverflowError` due to recursive calls. **Mitigation:** I applied `@ToString.Exclude` and `@EqualsAndHashCode.Exclude` to the non-owning side.
* **Orphan Management:** By utilizing `orphanRemoval = true` and `CascadeType.ALL`, I ensure that the database reflects the domain lifecycle correctly (e.g., when a user is deleted, their associated decks are cleaned up automatically).
* **Performance:** All `@ManyToOne` relationships are configured with `FetchType.LAZY` to avoid heavy "eager" loading, which significantly improves query performance as the application grows.

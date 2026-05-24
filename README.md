# MTG DeckBuilding App

A comprehensive full-stack application for Magic: The Gathering players to design, manage, and optimize their card decks with advanced filtering, deck statistics, and competitive insights.

## 🎮 Overview

Magic: The Gathering is one of the world's most complex card games. This application streamlines the deck-building process by providing an intuitive interface to search cards, manage deck composition, analyze statistics, and ensure format compliance.

**Perfect for:**
- Casual and competitive players
- Deck testers and theorycrafters
- New players learning deck building
- Collection managers

## ✨ Features

### Core Functionality
- 🔍 **Advanced Card Search** - Filter by name, type, cost, ability, color, format
- 🛠️ **Deck Builder** - Intuitive interface to add/remove cards and manage quantities
- 📊 **Deck Statistics** - Mana curve, color distribution, card type breakdown
- ✅ **Format Validation** - Check deck legality (Standard, Modern, Pioneer, Commander)
- 💾 **Deck Management** - Save, load, and organize multiple decks
- 📈 **Deck Analytics** - Win rates, meta information, card synergies
- 🔄 **Deck Import/Export** - Share decks via text format or links
- 🎨 **Visual Deck Preview** - See all cards with images and details

### Advanced Features
- Card pricing integration
- Suggested card replacements
- Deck comparison tools
- Sideboard management
- Card availability tracking

## 🛠️ Tech Stack

### Backend
- **Language:** Java
- **Framework:** Spring Boot / Spring MVC
- **Database:** MySQL / PostgreSQL
- **API:** RESTful API
- **Authentication:** Spring Security

### Frontend
- **Framework:** HTML5 / CSS3 / JavaScript
- **UI Library:** Bootstrap / Material Design
- **State Management:** Vanilla JS / React (if applicable)
- **API Client:** Fetch API / Axios

### External Services
- MTG Card Database API (Scryfall)
- Market price data (TCGPlayer)

## 📁 Project Structure

```
MTG-DeckBuilding-App/
├── README.md
├── backend/                    # Spring Boot API
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/mtgapp/
│   │   │   │       ├── controller/    # REST endpoints
│   │   │   │       ├── service/       # Business logic
│   │   │   │       ├── repository/    # Data access
│   │   │   │       ├── model/         # Entity classes
│   │   │   │       └── config/        # Configuration
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                       # Unit and integration tests
│   ├── pom.xml                         # Maven dependencies
│   └── Dockerfile
├── frontend/                   # HTML/CSS/JS UI
│   ├── index.html             # Dashboard
│   ├── deckbuilder.html       # Deck editor
│   ├── search.html            # Card search
│   ├── css/
│   │   └── styles.css         # Global styles
│   ├── js/
│   │   ├── app.js             # Main logic
│   │   ├── deckBuilder.js     # Deck functionality
│   │   └── cardSearch.js      # Search functionality
│   └── img/                   # Assets
└── docs/                      # Documentation
    ├── API.md                 # API documentation
    └── SETUP.md               # Setup guide
```

## 🚀 Getting Started

### Prerequisites
- **Backend:** Java 11+, Maven, MySQL/PostgreSQL
- **Frontend:** Modern web browser
- **API Key:** Scryfall API (free, no key needed)

### Backend Setup

1. **Clone the repository**
```bash
git clone https://github.com/ZurdiGonzi/MTG-DeckBuilding-App.git
cd MTG-DeckBuilding-App/backend
```

2. **Configure database**
```bash
# Edit application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/mtg_db
spring.datasource.username=root
spring.datasource.password=your_password
```

3. **Build and run**
```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**
```bash
cd ../frontend
```

2. **Serve locally**
```bash
# Using Python
python -m http.server 8000

# Or using Node.js
npx http-server
```

3. **Open browser**
```
http://localhost:8000
```

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Key Endpoints

#### Cards
```
GET    /cards                    # List all cards with pagination
GET    /cards/:id                # Get card details
GET    /cards/search?q=...       # Search cards by query
GET    /cards/filter?color=...   # Filter cards by criteria
```

#### Decks
```
GET    /decks                    # List user's decks
POST   /decks                    # Create new deck
GET    /decks/:id                # Get deck details
PUT    /decks/:id                # Update deck
DELETE /decks/:id                # Delete deck
POST   /decks/:id/validate       # Check format legality
GET    /decks/:id/stats          # Get deck statistics
```

#### Users (if applicable)
```
POST   /auth/register            # Register new user
POST   /auth/login               # Login
GET    /users/:id                # Get user profile
PUT    /users/:id                # Update profile
```

## 🔍 Example Usage

### Search for Cards
```javascript
fetch('http://localhost:8080/api/cards/search?q=lightning&format=standard')
  .then(res => res.json())
  .then(data => console.log(data))
```

### Create a Deck
```javascript
const deckData = {
  name: "Aggressive Red Deck",
  format: "standard",
  cards: [
    { cardId: "123", quantity: 4 },
    { cardId: "456", quantity: 3 }
  ]
};

fetch('http://localhost:8080/api/decks', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(deckData)
})
```

## 🎓 Learning Outcomes

This project demonstrates proficiency in:

### Backend Development
- RESTful API design and implementation
- Spring Boot framework and Spring Security
- Database design and SQL optimization
- Authentication and authorization
- Exception handling and validation

### Frontend Development
- Responsive web design
- DOM manipulation and event handling
- API integration with async/await
- User experience optimization
- State management

### Full-Stack Integration
- Client-server communication
- Data persistence and retrieval
- Real-time data updates
- Cross-origin resource sharing (CORS)

### Software Engineering
- MVC/N-tier architecture
- Design patterns (Repository, Service)
- Unit testing and integration testing
- Code organization and best practices
- Documentation standards

## 🔧 Technologies Deep Dive

### Backend Technologies
- **Spring Boot** - Rapid application development
- **Spring Security** - User authentication and authorization
- **Spring Data JPA** - ORM and database abstraction
- **Maven** - Build automation and dependency management
- **JUnit 5** - Unit testing framework

### Frontend Technologies
- **HTML5** - Semantic markup
- **CSS3** - Modern styling with Flexbox/Grid
- **JavaScript (ES6+)** - Dynamic interactions
- **Fetch API** - Asynchronous HTTP requests
- **Local Storage** - Client-side data persistence

## 📊 Database Schema (Overview)

Key entities:
- **User** - Player accounts and profiles
- **Deck** - Deck collections with metadata
- **Card** - Magic card information (imported from Scryfall)
- **DeckCard** - Join table for deck composition
- **Format** - MTG format rules and restrictions

## 🧪 Testing

### Run Backend Tests
```bash
mvn test
```

### Run Frontend Tests
```bash
npm test  # if using Jest or similar
```

## 🚢 Deployment

### Docker (Backend)
```bash
docker build -t mtg-app .
docker run -p 8080:8080 mtg-app
```

### Cloud Deployment
- Can be deployed to AWS, Heroku, Azure, or Google Cloud
- Frontend can be hosted on GitHub Pages, Netlify, or Vercel

## 📝 Notes

- Uses **Scryfall API** for comprehensive card data
- Supports multiple MTG formats (Standard, Modern, Pioneer, Commander)
- Includes data validation and error handling
- Designed with scalability in mind

## 🎯 Future Enhancements

- [ ] Mobile app version (React Native/Flutter)
- [ ] Real-time multiplayer deck building
- [ ] AI-powered deck suggestions
- [ ] Integration with MTGO (Magic Online)
- [ ] Tournament organizing features
- [ ] Social features (deck sharing, comments)
- [ ] Price tracking and marketplace integration

## 📄 License

This project is provided as-is for educational and personal use.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/ZurdiGonzi/MTG-DeckBuilding-App/issues).

## 👤 Author

**ZurdiGonzi**  
- GitHub: [@ZurdiGonzi](https://github.com/ZurdiGonzi)
- Portfolio: Full-stack Java Developer

---

**Enjoyed this project? Give it a ⭐ and share your feedback!**

For questions or collaboration inquiries, open an issue or contact directly.

---

*Last updated: May 2026*

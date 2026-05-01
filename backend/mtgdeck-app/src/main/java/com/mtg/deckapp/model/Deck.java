package com.mtg.deckapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ElementCollection
    @Column(name = "card_id")
    private List<String> cardList;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeckType deckType;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "price", nulleable = true)
    private String price;

}

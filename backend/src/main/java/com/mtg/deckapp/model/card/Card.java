package com.mtg.deckapp.model.card;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scryfall_id", nullable = false)
    private String scryfallId;

    @Column(nullable = false)
    @Builder.Default
    private int copies = 1;

    // Estado físico de la carta (opcional, útil para colecciones)
    @Column(name = "card_condition")
    private String condition;

    // Si esta instancia de carta está dentro de un mazo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private com.mtg.deckapp.model.deck.Deck deck;

    // Si esta instancia de carta pertenece a un archivador/colección
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private com.mtg.deckapp.model.card.Collection collection;
}

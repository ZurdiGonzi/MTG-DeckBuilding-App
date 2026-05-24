package com.mtg.deckapp.infrastructure.adapters.db.entities.reports;

import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.Deck;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("DECK")
@EqualsAndHashCode(callSuper = true)
public class DeckReport extends Report {
    @ManyToOne(fetch = FetchType.LAZY)
    private Deck reportedDeck;
}

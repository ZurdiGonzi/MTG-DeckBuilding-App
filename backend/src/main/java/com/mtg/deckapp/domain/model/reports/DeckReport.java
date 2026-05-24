package com.mtg.deckapp.domain.model.reports;

import com.mtg.deckapp.domain.model.deck.Deck;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeckReport extends Report {
    private Deck reportedDeck;
}

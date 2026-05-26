package com.mtg.deckapp.domain.model.card;

import com.mtg.deckapp.domain.model.deck.Deck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    private Long id;
    private String scryfallId;
    
    @Builder.Default
    private int copies = 1;
    
    private String condition;
    private Deck deck;
    private Collection collection;
}

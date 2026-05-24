package com.mtg.deckapp.model.reports;

import com.mtg.deckapp.model.*;
import com.mtg.deckapp.model.card.*;
import com.mtg.deckapp.model.commerce.*;
import com.mtg.deckapp.model.community.*;
import com.mtg.deckapp.model.deck.*;
import com.mtg.deckapp.model.user.*;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("DECK")
public class DeckReport extends Report {
    @ManyToOne(fetch = FetchType.LAZY)
    private Deck reportedDeck;
}
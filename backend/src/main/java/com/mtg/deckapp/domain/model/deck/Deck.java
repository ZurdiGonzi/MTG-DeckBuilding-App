package com.mtg.deckapp.domain.model.deck;

import com.mtg.deckapp.domain.model.card.Card;
import com.mtg.deckapp.domain.model.user.User;
import com.mtg.deckapp.domain.model.commerce.DeckEnrollment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deck {

    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Card> cards = new ArrayList<>();

    private DeckType deckType;
    private User owner;
    private int price;
    private String requiredProvider;
    private String commanderScryfallId;
    private String name;
    private String description;
    private String imageUrl;
    
    @Builder.Default
    private boolean active = true;
    
    @Builder.Default
    private DeckStatus status = DeckStatus.DRAFT;
    
    private boolean isPublic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<DeckEnrollment> enrollments = new ArrayList<>();
}

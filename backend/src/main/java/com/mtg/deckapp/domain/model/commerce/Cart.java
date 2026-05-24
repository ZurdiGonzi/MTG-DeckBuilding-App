package com.mtg.deckapp.domain.model.commerce;

import com.mtg.deckapp.domain.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    private Long id;
    private User user;
    
    @Builder.Default
    private List<DeckEnrollment> decks = new ArrayList<>();
    
    @Builder.Default
    private List<SubscriptionEnrollment> subscriptions = new ArrayList<>();
    
    @Builder.Default
    private List<TournamentEnrollment> tournaments = new ArrayList<>();
    
    private CreatorEnrollment creatorEnrollment;
    private int totalCost;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

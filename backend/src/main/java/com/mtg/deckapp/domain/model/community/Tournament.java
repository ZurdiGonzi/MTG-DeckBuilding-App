package com.mtg.deckapp.domain.model.community;

import com.mtg.deckapp.domain.model.deck.DeckType;
import com.mtg.deckapp.domain.model.user.User;
import com.mtg.deckapp.domain.model.commerce.TournamentEnrollment;
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
public class Tournament {
    private Long id;
    private String name;
    private String description;
    private String rules;
    private String imageUrl;
    private DeckType formatType;
    private LocalDateTime date;
    private int cost;
    private int prizePool;
    private String prizePoolCurrency;
    private int maxPlayers;
    private int minPlayers;
    private int currentPlayers;
    private boolean isPublic;
    
    @Builder.Default
    private boolean active = true;
    
    @Builder.Default
    private TournamentStatus status = TournamentStatus.DRAFT;
    
    private User owner;
    private Community community;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<TournamentEnrollment> enrollments = new ArrayList<>();
}

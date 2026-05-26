package com.mtg.deckapp.domain.model;

import com.mtg.deckapp.domain.model.user.User;
import com.mtg.deckapp.domain.model.deck.Deck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikedDeck {
    private Long id;
    private User user;
    private Deck deck;
    private LocalDateTime likedAt;
}

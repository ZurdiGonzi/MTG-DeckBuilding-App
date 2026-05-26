package com.mtg.deckapp.infrastructure.adapters.db.entities;

import com.mtg.deckapp.infrastructure.adapters.db.entities.card.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.commerce.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.community.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "liked_decks", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "deck_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikedDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @Column(name = "liked_at")
    private LocalDateTime likedAt;
}

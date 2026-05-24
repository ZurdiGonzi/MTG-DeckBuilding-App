package com.mtg.deckapp.infrastructure.adapters.db.entities.commerce;

import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.Deck;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "deck_enrollments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeckEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @Column(name = "price_paid", nullable = false)
    private int pricePaid;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid = false;

    @Column(name = "enrolled_at", nullable = false, updatable = false)
    private LocalDateTime enrolledAt;

    @PrePersist
    protected void onCreate() {
        this.enrolledAt = LocalDateTime.now();
    }
}

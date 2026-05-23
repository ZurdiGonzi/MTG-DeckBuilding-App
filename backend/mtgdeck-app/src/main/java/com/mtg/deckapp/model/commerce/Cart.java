package com.mtg.deckapp.model.commerce;

import com.mtg.deckapp.model.*;
import com.mtg.deckapp.model.card.*;
import com.mtg.deckapp.model.commerce.*;
import com.mtg.deckapp.model.community.*;
import com.mtg.deckapp.model.deck.*;
import com.mtg.deckapp.model.user.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @ManyToMany
    @JoinTable(
        name = "cart_decks",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "deck_enrollment_id")
    )
    @Builder.Default
    private List<DeckEnrollment> decks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "cart_subscriptions",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "subscription_id")
    )
    @Builder.Default
    private List<SuscriptionEnrollment> subscriptions = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "cart_tournaments",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    @Builder.Default
    private List<TournamentEnrrollment> tournaments = new ArrayList<>();

    // Un carrito puede contener una suscripción a creador que se está pagando
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_enrollment_id")
    private CreatorEnrrollment creatorEnrollment;

    private int totalCost;
    private String currency;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

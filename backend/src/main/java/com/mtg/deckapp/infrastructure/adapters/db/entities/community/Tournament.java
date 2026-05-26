package com.mtg.deckapp.infrastructure.adapters.db.entities.community;

import com.mtg.deckapp.infrastructure.adapters.db.entities.commerce.TournamentEnrollment;
import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.DeckType;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournaments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String rules;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "format_type")
    private DeckType formatType;

    @Column(name = "tournament_date")
    private LocalDateTime date;

    private int cost;

    @Column(name = "prize_pool")
    private int prizePool;

    @Column(name = "prize_pool_currency")
    private String prizePoolCurrency;

    @Column(name = "max_players")
    private int maxPlayers;

    @Column(name = "min_players")
    private int minPlayers;

    @Column(name = "current_players")
    private int currentPlayers;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Builder.Default
    private TournamentStatus status = TournamentStatus.DRAFT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TournamentEnrollment> enrollments = new ArrayList<>();
}

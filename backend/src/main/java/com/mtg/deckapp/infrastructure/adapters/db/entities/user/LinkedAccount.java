package com.mtg.deckapp.infrastructure.adapters.db.entities.user;

import com.mtg.deckapp.infrastructure.adapters.db.entities.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.card.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.commerce.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.community.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "linked_accounts", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "provider"})
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "provider", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class LinkedAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Column(name = "access_token", length = 2048)
    private String accessToken;

    @Column(name = "refresh_token", length = 2048)
    private String refreshToken;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "scopes")
    private String scopes;

    @Column(name = "token_type")
    private String tokenType;
}

package com.mtg.deckapp.infrastructure.adapters.db.entities.user;

import com.mtg.deckapp.infrastructure.adapters.db.entities.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.card.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.commerce.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.community.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.*;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("GOOGLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class GoogleAccount extends LinkedAccount {

    @Column(name = "google_id", unique = true)
    private String googleId;

    @Column(name = "email_verified")
    private Boolean emailVerified;
}

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
@DiscriminatorValue("PATREON")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PatreonAccount extends LinkedAccount {

    @Column(name = "patreon_id", unique = true)
    private String patreonId;

    @Column(name = "patreon_tier")
    private String patreonTier;

    @Column(name = "patreon_campaign_id")
    private String campaignId;
}

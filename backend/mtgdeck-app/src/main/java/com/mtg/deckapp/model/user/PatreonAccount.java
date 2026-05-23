package com.mtg.deckapp.model.user;

import com.mtg.deckapp.model.*;
import com.mtg.deckapp.model.card.*;
import com.mtg.deckapp.model.commerce.*;
import com.mtg.deckapp.model.community.*;
import com.mtg.deckapp.model.deck.*;
import com.mtg.deckapp.model.user.*;
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

    @Column(name = "patreon_id", unique = true, nullable = false)
    private String patreonId;

    @Column(name = "patreon_tier")
    private String patreonTier;
    
    @Column(name = "patreon_campaign_id")
    private String campaignId;
}

package com.mtg.deckapp.infrastructure.adapters.db.entities.reports;

import com.mtg.deckapp.infrastructure.adapters.db.entities.community.Community;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("COMMUNITY")
@EqualsAndHashCode(callSuper = true)
public class CommunityReport extends Report {
    @ManyToOne(fetch = FetchType.LAZY)
    private Community reportedCommunity;
}

package com.mtg.deckapp.infrastructure.adapters.db.entities.reports;

import com.mtg.deckapp.infrastructure.adapters.db.entities.community.Tournament;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("TOURNAMENT")
@EqualsAndHashCode(callSuper = true)
public class TournamentReport extends Report {
    @ManyToOne(fetch = FetchType.LAZY)
    private Tournament reportedTournament;
}

package com.mtg.deckapp.domain.model.reports;

import com.mtg.deckapp.domain.model.community.Tournament;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TournamentReport extends Report {
    private Tournament reportedTournament;
}

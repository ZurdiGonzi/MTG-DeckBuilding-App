package com.mtg.deckapp.domain.model.commerce;

import com.mtg.deckapp.domain.model.user.User;
import com.mtg.deckapp.domain.model.community.Tournament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentEnrollment {
    private Long id;
    private User user;
    private Tournament tournament;
    private int pricePaid;
    private boolean isPaid = false;
    private LocalDateTime enrolledAt;
}

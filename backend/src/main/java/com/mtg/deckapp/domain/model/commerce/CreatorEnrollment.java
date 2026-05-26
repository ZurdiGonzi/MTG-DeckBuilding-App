package com.mtg.deckapp.domain.model.commerce;

import com.mtg.deckapp.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatorEnrollment {
    private Long id;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt; 
    private int cost;
    private boolean isPaid;
}

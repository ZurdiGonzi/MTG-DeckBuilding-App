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
public class SubscriptionEnrollment {
    private Long id;
    private User subscriber;
    private User creator;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private int price;
    private boolean isPaid = false;
}

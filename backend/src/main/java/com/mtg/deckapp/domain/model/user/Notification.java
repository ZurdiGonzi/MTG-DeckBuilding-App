package com.mtg.deckapp.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    private Long id;
    private User user;
    private String message;
    private NotificationType type;
    private boolean isRead = false;
    private LocalDateTime createdAt;
}

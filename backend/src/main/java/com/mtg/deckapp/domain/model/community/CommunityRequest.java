package com.mtg.deckapp.domain.model.community;

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
public class CommunityRequest {
    private Long id;
    private Community community;
    private User user;
    private RequestStatus status;
    private LocalDateTime createdAt;
}

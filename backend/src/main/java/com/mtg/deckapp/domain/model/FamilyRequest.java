package com.mtg.deckapp.domain.model;

import com.mtg.deckapp.domain.model.user.User;
import com.mtg.deckapp.domain.model.community.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyRequest {
    private Long id;
    private Family family;
    private User user;
    private RequestStatus status;
    private LocalDateTime createdAt;
}

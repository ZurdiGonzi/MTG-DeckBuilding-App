package com.mtg.deckapp.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class LinkedAccount {
    private Long id;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;
    
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expiresAt;
    private String scopes;
    private String tokenType;
}

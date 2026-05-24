package com.mtg.deckapp.domain.model.card;

import com.mtg.deckapp.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collection {
    private Long id;
    private User user;
    private String name;
    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Card> cards = new ArrayList<>();
}

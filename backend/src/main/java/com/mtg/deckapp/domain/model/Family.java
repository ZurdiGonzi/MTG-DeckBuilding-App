package com.mtg.deckapp.domain.model;

import com.mtg.deckapp.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Family {
    private Long id;
    private String name;
    
    @Builder.Default
    private int numMaxUsers = 5;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<User> users = new ArrayList<>();

    private User owner;

    @Builder.Default
    private List<FamilyRequest> requests = new ArrayList<>();
}

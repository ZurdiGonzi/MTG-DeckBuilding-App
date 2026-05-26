package com.mtg.deckapp.domain.model.community;

import com.mtg.deckapp.domain.model.Location;
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
public class Community {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Location location;
    private User owner;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<User> members = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Tournament> tournaments = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<CommunityRequest> requests = new ArrayList<>();
}

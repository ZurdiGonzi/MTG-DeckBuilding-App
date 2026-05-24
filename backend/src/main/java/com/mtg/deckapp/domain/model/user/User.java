package com.mtg.deckapp.domain.model.user;

import com.mtg.deckapp.domain.model.Family;
import com.mtg.deckapp.domain.model.card.Card;
import com.mtg.deckapp.domain.model.card.Collection;
import com.mtg.deckapp.domain.model.community.Community;
import com.mtg.deckapp.domain.model.community.Tournament;
import com.mtg.deckapp.domain.model.deck.Deck;
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
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String description;
    private UserType userType;
    private String profileImageUrl;
    
    @Builder.Default
    private boolean active = true;
    
    @Builder.Default
    private UserStatus status = UserStatus.PENDING_ACTIVATION;

    @Builder.Default
    private boolean muteCommunityNotifications = false;

    @Builder.Default
    private List<LinkedAccount> linkedAccounts = new ArrayList<>();

    private Family family;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Community> communities = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Deck> decks = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Collection> collectionItems = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Tournament> ownedTournaments = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Card> searchedCards = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Card> tradeCards = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Notification> notifications = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<com.mtg.deckapp.domain.model.FamilyRequest> familyRequests = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<com.mtg.deckapp.domain.model.community.CommunityRequest> communityRequests = new ArrayList<>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

package com.mtg.deckapp.infrastructure.adapters.db.entities;

import com.mtg.deckapp.infrastructure.adapters.db.entities.card.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.commerce.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.community.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.deck.*;
import com.mtg.deckapp.infrastructure.adapters.db.entities.user.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "families")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    private int numMaxUsers = 5;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "family")
    @Builder.Default
    private List<User> users = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<FamilyRequest> requests = new ArrayList<>();
}

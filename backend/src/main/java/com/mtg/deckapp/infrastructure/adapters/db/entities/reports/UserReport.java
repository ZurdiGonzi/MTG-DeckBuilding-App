package com.mtg.deckapp.infrastructure.adapters.db.entities.reports;

import com.mtg.deckapp.infrastructure.adapters.db.entities.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("USER")
@EqualsAndHashCode(callSuper = true)
public class UserReport extends Report {
    @ManyToOne(fetch = FetchType.LAZY)
    private User reportedUser;
}

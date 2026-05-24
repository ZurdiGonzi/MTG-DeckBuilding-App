package com.mtg.deckapp.domain.model.reports;

import com.mtg.deckapp.domain.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserReport extends Report {
    private User reportedUser;
}

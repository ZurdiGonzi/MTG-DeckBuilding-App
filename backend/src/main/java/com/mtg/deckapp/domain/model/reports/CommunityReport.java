package com.mtg.deckapp.domain.model.reports;

import com.mtg.deckapp.domain.model.community.Community;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommunityReport extends Report {
    private Community reportedCommunity;
}

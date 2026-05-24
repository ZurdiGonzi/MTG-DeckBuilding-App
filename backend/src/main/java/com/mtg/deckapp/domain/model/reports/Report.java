package com.mtg.deckapp.domain.model.reports;

import com.mtg.deckapp.domain.model.user.User;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public abstract class Report {
    private Long id;
    private User reportingUser;
    private String reason;
    private LocalDateTime reportDate;
    private User validateReportBy;
}

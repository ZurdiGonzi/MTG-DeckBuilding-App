package com.mtg.deckapp.infrastructure.adapters.db.entities.reports;

import com.mtg.deckapp.infrastructure.adapters.db.entities.user.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "report_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User reportingUser;

    private String reason;

    private LocalDateTime reportDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validate_report_by_id")
    private User validateReportBy;
}

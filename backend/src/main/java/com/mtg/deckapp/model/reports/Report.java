package com.mtg.deckapp.model.reports;

import com.mtg.deckapp.model.*;
import com.mtg.deckapp.model.card.*;
import com.mtg.deckapp.model.commerce.*;
import com.mtg.deckapp.model.community.*;
import com.mtg.deckapp.model.deck.*;
import com.mtg.deckapp.model.user.*;
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

    @OneToOne(fetch = FetchType.LAZY)
    private User validateReportBy;
}
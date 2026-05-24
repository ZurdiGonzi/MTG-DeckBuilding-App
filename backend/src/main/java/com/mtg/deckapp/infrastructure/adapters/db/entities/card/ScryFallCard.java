package com.mtg.deckapp.infrastructure.adapters.db.entities.card;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "scryfallcards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScryFallCard {

    @Id
    private String scryfallId;

    private String name;
    private String lang;

    @Column(name = "released_at")
    private String releasedAt;

    @Column(name = "mana_cost")
    private String manaCost;

    private Double cmc;

    @Column(name = "type_line")
    private String typeLine;

    @Column(columnDefinition = "TEXT", name = "oracle_text")
    private String oracleText;

    private String power;
    private String toughness;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "colors", columnDefinition = "text[]")
    private List<String> colors;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "color_identities", columnDefinition = "text[]")
    private List<String> colorIdentity;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "keywords", columnDefinition = "text[]")
    private List<String> keywords;

    @Column(name = "set_code")
    private String set;

    @Column(name = "set_name")
    private String setName;

    private String rarity;
    private String artist;

    @Column(name = "image_uri_normal")
    private String imageUriNormal;

    @Column(name = "image_uri_art_crop")
    private String imageUriArtCrop;

    @Column(name = "price_usd")
    private String priceUsd;

    @Column(name = "price_eur")
    private String priceEur;

    @Column(name = "legal_standard")
    private String legalStandard;

    @Column(name = "legal_modern")
    private String legalModern;

    @Column(name = "legal_commander")
    private String legalCommander;
}

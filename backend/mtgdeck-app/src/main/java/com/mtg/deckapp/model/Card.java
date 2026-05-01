package com.mtg.deckapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    private String scryfallId; // Scryfall UUID

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

    // Relaciones para listas simples de Strings
    @ElementCollection
    @CollectionTable(name = "card_colors", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "color")
    private List<String> colors;

    @ElementCollection
    @CollectionTable(name = "card_color_identities", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "color_identity")
    private List<String> colorIdentity;

    @ElementCollection
    @CollectionTable(name = "card_keywords", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "keyword")
    private List<String> keywords;

    @Column(name = "set_code")
    private String set;

    @Column(name = "set_name")
    private String setName;

    private String rarity;
    private String artist;

    // Imágenes (extraemos las más útiles para la UI en vez de crear otra tabla)
    @Column(name = "image_uri_normal")
    private String imageUriNormal;

    @Column(name = "image_uri_art_crop")
    private String imageUriArtCrop;

    // Precios (se guardan como String para evitar problemas de coma flotante en monedas)
    @Column(name = "price_usd")
    private String priceUsd;

    @Column(name = "price_eur")
    private String priceEur;

    // Legalidades de los formatos más jugados
    @Column(name = "legal_standard")
    private String legalStandard;

    @Column(name = "legal_modern")
    private String legalModern;

    @Column(name = "legal_commander")
    private String legalCommander;

}

    // 
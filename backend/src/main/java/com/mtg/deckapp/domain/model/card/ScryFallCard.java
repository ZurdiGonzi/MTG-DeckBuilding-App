package com.mtg.deckapp.domain.model.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScryFallCard {
    private String scryfallId;
    private String name;
    private String lang;
    private String releasedAt;
    private String manaCost;
    private Double cmc;
    private String typeLine;
    private String oracleText;
    private String power;
    private String toughness;
    private List<String> colors;
    private List<String> colorIdentity;
    private List<String> keywords;
    private String set;
    private String setName;
    private String rarity;
    private String artist;
    private String imageUriNormal;
    private String imageUriArtCrop;
    private String priceUsd;
    private String priceEur;
    private String legalStandard;
    private String legalModern;
    private String legalCommander;
}

package com.mtg.deckapp.model.card;
import java.util.List;
import java.util.Map;

public record ScryFallMetaData(
    String lang,
    String releaseAt,
    String manaCost,
    String oracleText,
    String power,
    String toughness,
    String rarity,
    String artist,
    List<String> colors,
    List<String> keywords,
    Map<String,String> imageUris,
    Map <String, String> prices,
    Map <String, String> legalities
) {}

package com.cm.easydates;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe utilitaire pour la conversion et le formatage de dates.
 */
public class DateConverter {

    /**
     * Formate un objet {@link Date} selon le motif fourni.
     *
     * @param date   La date à formater. Ne doit pas être null.
     * @param pattern Le format de date souhaité (ex: "dd/MM/yyyy", "yyyy-MM-dd HH:mm").
     * @return Une chaîne formatée représentant la date.
     * @throws IllegalArgumentException si la date est null ou le format invalide.
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("La date ne peut pas être null.");
        }

        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Le format ne peut pas être vide.");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}


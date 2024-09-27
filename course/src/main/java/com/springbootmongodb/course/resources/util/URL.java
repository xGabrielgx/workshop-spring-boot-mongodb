package com.springbootmongodb.course.resources.util;

import org.springframework.cglib.core.Local;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDateTime convertDate(String textDate, LocalDateTime defaultValue) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.of("GMT"));

        try {
            return LocalDateTime.from(fmt.parse(textDate));
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}

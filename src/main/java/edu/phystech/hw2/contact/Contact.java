package edu.phystech.hw2.contact;

import java.util.Objects;
import java.util.regex.Pattern;

public record Contact(String username, String email) implements Comparable<Contact> {

    public static final String UNKNOWN_EMAIL = "unknown@gmail.com";
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@gmail\\.com$");

    public Contact(String username) {
        this(validateUsername(username), UNKNOWN_EMAIL);
    }

    public Contact {
        username = validateUsername(username);
        email = validateEmail(email);
    }

    private static String validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidContactFieldException("username");
        }
        return username.trim();
    }

    private static String validateEmail(String email) {
        if (email == null || email.isEmpty() || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidContactFieldException("email");
        }
        return email;
    }

    @Override
    public int compareTo(Contact other) {
        return Integer.compare(this.username.length(), other.username.length());
    }
}
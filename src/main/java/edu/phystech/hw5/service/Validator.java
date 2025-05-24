package edu.phystech.hw5.service;

import edu.phystech.hw5.exception.ValidationException;

/**
 * @author kzlv4natoly & notjik
 */
public interface Validator {
    void validate(Object object) throws ValidationException;
}

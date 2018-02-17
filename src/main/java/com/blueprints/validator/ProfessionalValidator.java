package com.blueprints.validator;

import com.blueprints.form.Professional;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("professionalValidator")
public class ProfessionalValidator implements Validator {

    public boolean supports(Class<?> clazz) {

        return Professional.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        //Professional professional = (Professional) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "position.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "company.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "years", "years.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "location.empty");

    }
}

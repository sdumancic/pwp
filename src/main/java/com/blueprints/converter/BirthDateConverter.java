package com.blueprints.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthDateConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("mm/yy/dd");
        Date birthDate;
        try {
            birthDate = format.parse(text.trim());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            birthDate = new Date();
        }
        setValue(birthDate);
    }

}

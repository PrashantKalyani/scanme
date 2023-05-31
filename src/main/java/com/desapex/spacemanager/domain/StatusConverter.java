package com.desapex.spacemanager.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean status) {
        return status ? "Inactive" : "Active"; // Reverse the conversion logic
    }

    @Override
    public Boolean convertToEntityAttribute(String dbStatus) {
        return "Inactive".equals(dbStatus); // Reverse the conversion logic
    }
}
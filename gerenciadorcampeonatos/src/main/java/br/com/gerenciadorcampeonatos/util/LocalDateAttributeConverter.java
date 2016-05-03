package br.com.gerenciadorcampeonatos.util;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate entityValue) {
        return (entityValue == null) ? null : Date.valueOf(entityValue);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date databaseValue) {
        return (databaseValue == null) ? null : databaseValue.toLocalDate();
    }
}

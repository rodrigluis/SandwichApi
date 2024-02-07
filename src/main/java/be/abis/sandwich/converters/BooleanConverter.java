package be.abis.sandwich.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.lang.Boolean.FALSE;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Character> {
    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if (attribute != null) {
            if (attribute) {
                return 'Y';
            } else {
                return 'N';
            }
        }
        return 'N';
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData != null) {
            return dbData.equals('Y');
        }
        return FALSE;
    }

}

package com.gui9394.apivalidation.validation.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gui9394.apivalidation.validation.ValueOfEnum;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(ValueOfEnum annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants()).map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return acceptedValues.contains(value);
    }
}

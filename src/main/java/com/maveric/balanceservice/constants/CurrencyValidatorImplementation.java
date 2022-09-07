package com.maveric.balanceservice.constants;

import com.maveric.balanceservice.enumeration.Currency;
import com.maveric.balanceservice.exception.InvalidException;
import org.springframework.http.converter.HttpMessageNotReadableException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CurrencyValidatorImplementation implements ConstraintValidator< CurrencyValidation,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final List<String> commType = Arrays.asList("INR", "DOLLAR", "EURO");
        return commType.contains(value);
    }
}
package com.maveric.balanceservice.constants;


import com.maveric.balanceservice.enumeration.Currency;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { CurrencyValidatorImplementation.class })
public @interface CurrencyValidation {
    String message() default "Currency should be INR/DOLLAR/EURO";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

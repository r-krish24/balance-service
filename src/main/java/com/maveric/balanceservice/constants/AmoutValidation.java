package com.maveric.balanceservice.constants;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { AmountValidatorImplementation.class })
public @interface AmoutValidation {
    String message() default "Amount is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

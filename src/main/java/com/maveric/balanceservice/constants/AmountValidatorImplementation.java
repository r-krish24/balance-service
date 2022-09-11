package com.maveric.balanceservice.constants;

import com.maveric.balanceservice.exception.BalanceNotFoundException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.Integer.parseInt;

public class AmountValidatorImplementation implements ConstraintValidator<AmoutValidation,String> {
    public boolean isValid(String amount, ConstraintValidatorContext constraintValidatorContext) {
        if(amount != null &&
                amount.matches("[0-9]+") &&
                parseInt(amount)>0)
        {
            System.out.println(amount);
            System.out.println(parseInt(amount));
            return true;
        }
        else {
            throw new BalanceNotFoundException("Amount should be positive and valid");
        }
    }
}
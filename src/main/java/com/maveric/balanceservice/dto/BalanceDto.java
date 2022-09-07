package com.maveric.balanceservice.dto;

import com.maveric.balanceservice.constants.CurrencyValidation;
import com.maveric.balanceservice.enumeration.Currency;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor

public class BalanceDto {
    private String  _id;

    @NotBlank(message = "Account Id is mandatory")
    private String accountId;

    @NotNull(message = "Amount is mandatory")
    @Positive(message = "Amount must be positive")
    private Number amount;
    @CurrencyValidation(message = "Currency")
    @NotNull(message = "Currency is mandatory INR/DOLLAR/EURO ")
    private Currency currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

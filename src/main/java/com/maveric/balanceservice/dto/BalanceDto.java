package com.maveric.balanceservice.dto;

import com.maveric.balanceservice.enumeration.Currency;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor

public class BalanceDto {
    private String  _id;
    private String accountId;
    private Number amount;
    private Currency currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

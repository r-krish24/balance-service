package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

import java.util.List;

public interface BalanceService {
    public List<BalanceDto> getBalances(Integer page, Integer pageSize);

    BalanceDto getBalanceByAccountId(String accountId);

    public BalanceDto createBalance(BalanceDto balanceDto);

    public BalanceDto getBalanceDetails(String balanceId);
    public String deleteBalance(String balanceId);

    public BalanceDto updateBalance(String balanceId,BalanceDto balanceDto);
}

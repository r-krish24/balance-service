package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import static com.maveric.balanceservice.constants.Constants.*;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private BalanceRepository repository;

    @Autowired
    private BalanceMapper mapper;


    @Override
    public BalanceDto getBalanceByAccountId(String accountId) {

        Balance balanceResult = repository.findByAccountId(accountId);
        if (balanceResult != null)
            return mapper.map((Balance) balanceResult);
        else
            return new BalanceDto();
    }

    public BalanceDto createBalance(String accountId, BalanceDto balanceDto) {
        if (accountId.equals(balanceDto.getAccountId())) {
            if(repository.findByAccountId(accountId)==null) {


                balanceDto.setCreatedAt(getCurrentDateTime());
                Balance balance = mapper.map(balanceDto);
                Balance balanceResult = repository.save(balance);
                return mapper.map(balanceResult);
            }
            else {
                throw new BalanceNotFoundException("Balance already exists for this Account Id-"+balanceDto.getAccountId());
            }
        } else {
            throw new BalanceNotFoundException("Account Id not found! Cannot create balance.");
        }
    }

    @Override
    public BalanceDto getBalanceDetails(String accountId,String balanceId) {
        Balance balanceResult = repository.findById(balanceId).orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
        return mapper.map(balanceResult);
    }

    @Override
    public String deleteBalance(String balanceId) {
        if(!repository.findById(balanceId).isPresent())
        {
            throw new BalanceNotFoundException(BALANCE_NOT_FOUND_MESSAGE+balanceId);
        }
        repository.deleteById(balanceId);
        return BALANCE_DELETED_SUCCESS;
    }
    @Override
    public String deleteBalanceByAccountId(String accountId) {
        repository.deleteByAccountId(accountId);
        return BALANCE_DELETED_SUCCESS;
    }

    @Override
    public BalanceDto updateBalance(String accountId, String balanceId, BalanceDto balanceDto) {
        if (accountId.equals(balanceDto.getAccountId())) {
            Balance balanceResult = repository.findById(balanceId).orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
            balanceResult.set_id(balanceResult.get_id());
            balanceResult.setAmount(balanceDto.getAmount());
            balanceResult.setCurrency(balanceDto.getCurrency());
            balanceResult.setAccountId(balanceResult.getAccountId());
            balanceResult.setCreatedAt(balanceResult.getCreatedAt());
            balanceResult.setUpdatedAt(getCurrentDateTime());
            Balance accountUpdated = repository.save(balanceResult);
            return mapper.map(accountUpdated);
        } else {
            throw new BalanceNotFoundException("Account Id not found! Cannot Update Balance.");
        }
    }
}

package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1")
public class BalanceController {
    @Autowired
    BalanceService balanceService;

    /* Returns the User Balance details*/
    @GetMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> getBalances(@PathVariable String accountId) {
        BalanceDto balanceDtoResponse = balanceService.getBalanceByAccountId(accountId);
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }
    /* Saving the balance details by accountId */
    @PostMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> createBalance(@PathVariable String accountId,@Valid @RequestBody BalanceDto balanceDto) {
        BalanceDto balanceDtoResponse = balanceService.createBalance(accountId,balanceDto);
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.CREATED);
    }
    /* Returns the balance amount by balanceId */
    @GetMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<String> getBalanceDetails(@PathVariable String accountId,@PathVariable String balanceId) {
        BalanceDto balanceDtoResponse = balanceService.getBalanceDetails(accountId,balanceId);
        return new ResponseEntity<>(String.valueOf(balanceDtoResponse.getAmount()), HttpStatus.OK);
    }

    /* Update Balance details by balanceId */
    @PutMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> updateBalance(@PathVariable String accountId,@PathVariable String balanceId,@Valid @RequestBody BalanceDto balanceDto) {
        BalanceDto balanceDtoResponse = balanceService.updateBalance(accountId,balanceId,balanceDto);
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }
    /* Delete Balance details by balanceId */
    @DeleteMapping("accounts/{accountId}/balances/{balancesId}")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId,@PathVariable String balancesId) {
        String result = balanceService.deleteBalance(balancesId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /* Delete Balance details by accountId */
    @DeleteMapping("accounts/{accountId}/balances")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId) {
        String result = balanceService.deleteBalanceByAccountId(accountId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

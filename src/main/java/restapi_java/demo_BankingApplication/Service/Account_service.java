package restapi_java.demo_BankingApplication.Service;

import restapi_java.demo_BankingApplication.DTO.AccountDto;
import restapi_java.demo_BankingApplication.Entity.Account;

import java.util.ArrayList;
import java.util.List;

public interface Account_service {
     AccountDto createAccount(AccountDto account);
     AccountDto getAccountById(Long id);
     AccountDto DepositAmount(Long id,double amount);

     AccountDto withdrawAmount(Long id ,double amount);

     List<AccountDto> getAllAccounts();
}

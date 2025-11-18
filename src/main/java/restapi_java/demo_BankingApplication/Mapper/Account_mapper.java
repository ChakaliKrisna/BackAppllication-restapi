package restapi_java.demo_BankingApplication.Mapper;

import restapi_java.demo_BankingApplication.DTO.AccountDto;
import restapi_java.demo_BankingApplication.Entity.Account;

public class Account_mapper {

    public static Account mapAccount(AccountDto accountDto){

        return new Account(accountDto.account_holder(),accountDto.balance());
    }


public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(account.getId(),account.getAccount_holder(),account.getBalance());
}

}

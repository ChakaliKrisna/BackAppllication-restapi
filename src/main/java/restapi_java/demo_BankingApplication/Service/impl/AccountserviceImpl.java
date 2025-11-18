package restapi_java.demo_BankingApplication.Service.impl;

import org.springframework.stereotype.Service;
import restapi_java.demo_BankingApplication.DTO.AccountDto;
import restapi_java.demo_BankingApplication.Entity.Account;
import restapi_java.demo_BankingApplication.Exception.AccountException;
import restapi_java.demo_BankingApplication.Mapper.Account_mapper;
import restapi_java.demo_BankingApplication.Repository.Accounts_Repo;
import restapi_java.demo_BankingApplication.Service.Account_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AccountserviceImpl implements Account_service {


    private Accounts_Repo accounts_repo;

    public AccountserviceImpl(Accounts_Repo accounts_repo) {
        this.accounts_repo = accounts_repo;
    }

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        Account account2= Account_mapper.mapAccount(accountdto);
        Account saveAccount=accounts_repo.save(account2);
    return Account_mapper.mapToAccountDto(saveAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {
//        Optional<Account> account= accounts_repo.findById(id).orElseThrow(()  --> new RuntimeException("account does not exist"));

        Account account = accounts_repo.findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));

        return Account_mapper.mapToAccountDto(account);


    }

    @Override
    public AccountDto DepositAmount(Long id, double amount) {

        Account account = accounts_repo.findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));

         account.setBalance(account.getBalance()+amount);
         Account saved_account= accounts_repo.save(account);

         return Account_mapper.mapToAccountDto(saved_account);




//        return null;
    }

    @Override
    public AccountDto withdrawAmount(Long id, double amount) {
        Account account= accounts_repo.findById(id).orElseThrow(() -> new AccountException("account does not exist"));
        double balance= account.getBalance();
        if(balance>amount+100){
            account.setBalance(balance-amount);
        }
        else {
            throw new RuntimeException("Insufficient balance (min balance 100) // current balance: " + balance);


        }
        accounts_repo.save(account);
        return Account_mapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accounts_list=  accounts_repo.findAll();
        List<AccountDto> accountsdto_list=new ArrayList<>();
        for(Account acc:accounts_list){
            accountsdto_list.add(Account_mapper.mapToAccountDto(acc));

        }
        return accountsdto_list;

    }


}

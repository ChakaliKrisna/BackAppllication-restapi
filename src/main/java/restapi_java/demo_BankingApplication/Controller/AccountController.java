package restapi_java.demo_BankingApplication.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapi_java.demo_BankingApplication.DTO.AccountDto;
import restapi_java.demo_BankingApplication.Entity.Account;
import restapi_java.demo_BankingApplication.Service.Account_service;

import java.util.List;
import java.util.Map;

@RestController
 @RequestMapping("/api/accounts")
public class AccountController {

    public AccountController(Account_service accountService) {
        this.accountService = accountService;
    }

    private Account_service accountService;


    // add account rest api


    @PostMapping("/addAccount")
    public ResponseEntity<AccountDto> addAccount(@RequestBody  AccountDto accountDto){



        AccountDto accountdto = accountService.createAccount(accountDto);
        return new  ResponseEntity<>(accountdto, HttpStatus.CREATED);

    }


    //get account details by id

    @GetMapping("/byid")
    public ResponseEntity<AccountDto> getAccountById(@RequestBody Map<String ,Long> request){

        Long id=request.get("id");
        AccountDto Accountdto=accountService.getAccountById(id);
        return ResponseEntity.ok(Accountdto);



    }

    // deposit api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id , @RequestBody Map<String,Double> request){

        Double amount=request.get("amount");

         AccountDto accountdto= accountService.DepositAmount(id,amount);
         return ResponseEntity.ok(accountdto);

    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw( @PathVariable ("id") Long id, @RequestBody Map<String,Double> request){

        double amount=request.get("amount");
//        Long id=request1.get("id");
        System.out.println("*************** with draw *****");

        AccountDto accountDto=accountService.withdrawAmount(id,amount);


        return ResponseEntity.ok(accountDto);


    }



    // GET ALL ACCOUNTS API

@GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){

        List<AccountDto> account_dtoList = accountService.getAllAccounts();
        return ResponseEntity.ok(account_dtoList);

    }

}

package restapi_java.demo_BankingApplication.DTO;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String account_holder;
//    private double balance;
////    private String msg;
//}


public record AccountDto(Long id, String account_holder,Double balance) {


}
package restapi_java.demo_BankingApplication.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String account_holder;
    private double balance;


    public Account(String accountHolder, double balance) {
        this.account_holder=accountHolder;
        this.balance=balance;

    }
}

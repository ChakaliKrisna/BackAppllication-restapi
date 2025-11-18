package restapi_java.demo_BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restapi_java.demo_BankingApplication.Entity.Account;

public interface Accounts_Repo extends JpaRepository<Account,Long> {

}

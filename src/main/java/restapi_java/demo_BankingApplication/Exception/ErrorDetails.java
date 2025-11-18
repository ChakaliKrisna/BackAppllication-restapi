package restapi_java.demo_BankingApplication.Exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp, String message, String details, String errorcode) {




}

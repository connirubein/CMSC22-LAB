import java.util.*;

public class TestAccount{

   public static void main(String[] args) {
      
      Account a1 = new Account(123, 1000.0);
      System.out.println(a1);

      a1.setBalance(2000.0);

      System.out.println(a1);

      a1.credit(200.0);

      a1.debit(5000.0);
      
      a1.debit(500.0);

      System.out.println("Account Number (a1) is: " + a1.getAccountNumber());
      System.out.println("Balance (a1) is: " + a1.getBalance());
 
   }
}

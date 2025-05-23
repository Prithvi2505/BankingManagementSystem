import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class BankSystem {


    private ArrayList<BankingAccount> accounts = new ArrayList<>();

    public void createAccount(BankingAccount account) {
        accounts.add(account);
    }
    public BankingAccount getAccount(String accNo) {
        Iterator<BankingAccount> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            BankingAccount account = iterator.next();
            if (account.getAccountNumber().equals(accNo)) {
                return account;
            }
        }
        return null;
    }
    public void deleteAccount(String accNo){

        BankingAccount acc = getAccount(accNo);
        if(acc!=null){
            accounts.remove(acc);
            System.out.println("Account Deleted Successfully");
        }
        else {
            System.out.println("Account not found");
        }

    }
    public void listAccount(){
        if(accounts.isEmpty()){
            System.out.println("No accounts Found");
        }
        else{
            Iterator<BankingAccount> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                System.out.println("---------------------------------");
                BankingAccount account = iterator.next();
                account.showDetails();
            }
        }
    }

    public void updateAccount(String accNo,String newName, int newBalance) {
        BankingAccount account  = getAccount(accNo);
        if(account != null){
            if(newName!=null && !newName.isEmpty()){
                account.setAccountHolder(newName);
            }
            if (newBalance != 0 && newBalance>=1000) {
                account.setBalance(newBalance);
            }
            System.out.println("Account updated successfully.");
        }
        else {
            System.out.println("Account Not Found");
        }
    }

    public void filterAccountsByBalance(int minBalance) {
//        Predicate<BankingAccount> filter = acc -> acc.getBalance() > minBalance;
        Boolean found = true;
        if(found) {
            accounts.stream()
                    .filter(acc -> acc.getBalance() > minBalance) // filter by balance
                    .forEach(acc -> {
                        System.out.println("---------------------------------");
                        acc.showDetails();
                    });
            found = false;
        }

        if (found) {
            System.out.println("No accounts found with balance greater than " + minBalance);
        }
    }
    public double getTotalBalance() {
        double total = accounts.stream()
                .mapToDouble(BankingAccount::getBalance) // convert to DoubleStream
                .sum(); // sum up all balances

        return total;
    }



}

import java.util.ArrayList;

public class BankSystem {

    private ArrayList<BankingAccount> accounts = new ArrayList<>();

    public void createAccount(BankingAccount account) {
        accounts.add(account);
        System.out.println("Account Created Successfully");
    }
    public BankingAccount getAccount(String accNo) {
        for(BankingAccount account:accounts){
            if(account.getAccountNumber().equals(accNo)){
                return account;
            }
        }
        return  null;
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
            for(BankingAccount account : accounts){
                System.out.println("---------------------------------");
                account.showDetails();
            }
        }
    }



}

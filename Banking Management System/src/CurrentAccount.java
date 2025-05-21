public class CurrentAccount extends BankingAccount {
    CurrentAccount(String accountHolder,String accountNumber,int balance){
        super(accountHolder,accountNumber,balance);
    }

    @Override
    public void widthdraw(int amount){
        if(balance > 1000 && amount < balance){
            balance -= amount;
        }
        else {
            System.out.println("Insufficient balance");
        }
    }

}

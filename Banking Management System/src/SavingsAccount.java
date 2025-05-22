public class SavingsAccount extends BankingAccount{
    private static final double interestRate = 0.04;
    SavingsAccount(String accountHolder,String accountNumber,int balance){
        super(accountHolder,accountNumber,balance);
    }

    @Override
    public void widthdraw(int amount){
        if(balance > 500 && amount < balance){
            balance -= amount;
            System.out.println("Withdraw was successfull.");
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
    public double calculateInterest() {
        return balance*interestRate;
    }
}

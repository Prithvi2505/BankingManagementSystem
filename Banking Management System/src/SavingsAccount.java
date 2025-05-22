public class SavingsAccount extends BankingAccount{
    private static final double interestRate = 0.04;
    SavingsAccount(String accountHolder,String accountNumber,int balance){
        super(accountHolder,accountNumber,balance);
    }

    @Override
    public void widthdraw(int amount) throws  CustomException{
        if(balance > 500 && amount < balance){
            if(balance-amount < 500) {
                throw new CustomException("You Can't withdraw , Because You Minimum Balance will become less than 500");
            }
            else {
                balance -= amount;
                System.out.println("Withdraw was successfull.");
            }
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
    public double calculateInterest() {
        return balance*interestRate;
    }
}

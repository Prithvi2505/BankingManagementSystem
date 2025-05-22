public class CurrentAccount extends BankingAccount {
    CurrentAccount(String accountHolder,String accountNumber,int balance){
        super(accountHolder,accountNumber,balance);
    }

    @Override
    public void widthdraw(int amount) throws CustomException{
        if(balance > 1000 && amount < balance){
            if(balance-amount<1000){
                throw new CustomException("You Can't withdraw , Because You Minimum Balance will become less than 1000");
            }
            else{
                balance -= amount;
                System.out.println("Withdraw was successfull.");
            }

        }
        else {
            System.out.println("Insufficient balance");
        }
    }

}

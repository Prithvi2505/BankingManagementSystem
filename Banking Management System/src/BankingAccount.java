public abstract class BankingAccount {
    private String accountHolder;
    private String accountNumber;
    protected  int balance;
    BankingAccount(String accountHolder,String accountNumber,int balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void showDetails() {
        System.out.println("Account Holder :"+accountHolder);
        System.out.println("Account Number :"+accountNumber);
        System.out.println("Account Balance :"+balance);
    }
    public void deposit(int amount){
        balance += amount;
    }
    public abstract void widthdraw(int amount);
}

import java.awt.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CustomException {

        MyInterface createMessage = (name,type) -> {
            System.out.println("Created "+ type + " Account for "+ name  );
        };


        Scanner sc = new Scanner(System.in);
        BankSystem bank = new BankSystem();
        int choice;
        do {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("6. List All Accounts");
            System.out.println("7. Update Account");
            System.out.println("8. Filter Accounts By Balance");
            System.out.println("9. Total Balance in Bank");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear the invalid input
                choice = -1; // force the loop to continue
                continue;
            }
            sc.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("Enter type of Account (savings/current): ");
                    String type = sc.nextLine();
                    System.out.println("Enter Account Holder Name: ");
                    String accHolder = sc.nextLine();
                    System.out.println("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    int balance = 0;
                    try{
                        System.out.println("Enter Your Initial Balance: ");
                         balance = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid balance input. Please enter a numeric value.");
                        sc.nextLine();
                        break;
                    }

                    if(type.equals("savings")){
                        bank.createAccount(new SavingsAccount(accHolder,accNo,balance));
                        createMessage.message(accHolder,type);
                    } else if (type.equals("current")) {
                        bank.createAccount(new CurrentAccount(accHolder,accNo,balance));
                        createMessage.message(accHolder,type);
                    }
                    else  {
                        System.out.println("Invalid Account Type");
                    }
                }
                case 2 ->{
                    System.out.println("Enter Account Number");
                    String accNo  = sc.nextLine();
                    BankingAccount acc = bank.getAccount(accNo);
                    if(acc != null) {
                        acc.showDetails();
                    }
                    else {
                        System.out.println("Account Not Found");
                    }
                }
                case 3 -> {
                    System.out.println("Enter Account Number");
                    String accNo  = sc.nextLine();
                    BankingAccount acc = bank.getAccount(accNo);
                    if(acc != null) {
                        int amount =0;
                        try{
                        System.out.println("Enter Amount: ");
                        amount = sc.nextInt();
                        sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Invalid amount input. Please enter a numeric value.");
                            sc.nextLine();
                            break;
                        }
                        acc.deposit(amount);
                        System.out.println("Deposited successfully.");
                    }
                    else {
                        System.out.println("Account Not Found");
                    }
                }
                case 4 -> {
                    System.out.println("Enter Account Number");
                    String accNo  = sc.nextLine();
                    BankingAccount acc = bank.getAccount(accNo);
                    if(acc != null) {
                        int amount =0;
                        try{
                            System.out.println("Enter Amount: ");
                            amount = sc.nextInt();
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Invalid amount input. Please enter a numeric value.");
                            sc.nextLine();
                            break;
                        }
                        acc.widthdraw(amount);
                    }
                    else {
                        System.out.println("Account Not Found");
                    }
                }
                case 5 -> {
                    System.out.println("Enter Account Number");
                    String accNo  = sc.nextLine();
                    bank.deleteAccount(accNo);
                }
                case 6 -> {
                    bank.listAccount();
                }
                case 7 -> {
                    System.out.println("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    BankingAccount acc = bank.getAccount(accNo);
                    if(acc != null) {
                    System.out.println("Enter New Account Holder: ");
                    String newName = sc.nextLine();
                    int newBalance = 0;
                    try{
                        System.out.println("Update Your initial  Balance: ");
                        newBalance = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid balance input. Please enter a numeric value.");
                        sc.nextLine();
                        break;
                    }
                    bank.updateAccount(accNo,newName,newBalance);
                    }
                    else {
                        System.out.println("Account Not Found");
                    }
                }
                case 8 -> {
                    System.out.print("Enter minimum balance: ");
                    int min = sc.nextInt();
                    sc.nextLine();
                    bank.filterAccountsByBalance(min);
                }
                case 9-> {
                    double total = bank.getTotalBalance();
                    System.out.println("The total balance in bank is: " + total);
                }
                case 0 -> System.out.println("Exiting. Thank you!");
                default -> System.out.println("Invalid option.");

            }
        }while (choice!=0);
        sc.close();
    }
}

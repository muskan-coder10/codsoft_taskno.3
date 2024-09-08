// Task - 3
// Atm Interface


    import java.util.Scanner;

      class BankAccount {
          private int balance;

          public BankAccount() {
              balance = 0;
          }

          public BankAccount(int balance) {
              this.balance = balance;
          }

          public void deposit(int amount) {
              if (amount > 0) {
                  this.balance += amount;
                  System.out.println("Deposit of " + amount + " Rupee successfully obtained.");
              } else {
                  System.out.println("Invalid deposit amount.");
              }
          }

          public void withdraw(int amount) {
              if (amount > 0 && amount <= this.balance) {
                  this.balance -= amount;
                  System.out.println("Withdraw of " + amount + " Rupee successfully processed.");
              } else {
                  System.out.println("Insufficient balance or invalid withdrawal amount.");
              }
          }

          public int getBalance() {
              return this.balance;
          }
      }

      class Atm {
          private BankAccount account;

          public Atm(BankAccount account) {
              this.account = account;
          }

          public void display() {
              System.out.println("Select Option:");
              System.out.println("1. Deposit");
              System.out.println("2. Withdraw");
              System.out.println("3. Check your current balance");
              System.out.println("4. Exit from this page");
          }

          public void run() {
              Scanner sc = new Scanner(System.in);
              int choice;
              do {
                  display();
                  System.out.println("Enter Your Choice:");
                  choice = sc.nextInt();

                  switch (choice) {
                      case 1:
                          System.out.println("Enter Amount to Deposit:");
                          int deposit = sc.nextInt();
                          account.deposit(deposit);
                          break;

                      case 2:
                          System.out.println("Enter Amount to Withdraw:");
                          int withdraw = sc.nextInt();
                          account.withdraw(withdraw);
                          break;

                      case 3:
                          System.out.println("Your current balance is: " + account.getBalance() + " Rupee.");
                          break;

                      case 4:
                          System.out.println("Exiting from this page.");
                          System.out.println("Thank you for visiting our bank.");
                          break;

                      default:
                          System.out.println("Invalid option. Kindly select a valid option from the menu.");
                  }
              } while (choice != 4);
              sc.close();
          }
      }

      public class Atm_interface_ {

          public static void main(String[] args) {
              Scanner sc = new Scanner(System.in);
              BankAccount userAccount = new BankAccount(700000);
              Atm atm = new Atm(userAccount);
              System.out.println("Enter your security pin to access your account:");
              String pin = sc.nextLine();
              if (pin.equals("1006")) {
                  atm.run();
              } else {
                  System.out.println("Invalid security pin. Kindly provide the correct security pin.");
              }
              sc.close();

          }
      }
      
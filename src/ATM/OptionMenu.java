package ATM;

import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    boolean shouldExit = false; // introduce a flag

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(123456789, 1234);
                data.put(987654321, 9876);

                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong customer number or PIN number." + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        if (shouldExit) {
            System.out.println("Thank you for using this ATM, bye.");
            return;
        }

        System.out.println("Select the account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, bye.");
                shouldExit = true; // set the flag
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                shouldExit = true; // set the flag
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");
                shouldExit = true; // set the flag
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }
}

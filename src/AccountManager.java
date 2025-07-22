import java.util.*;

public class AccountManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();
        String fileName = "mayer meye.txt";
        accounts.put("A1", new Account("A1", "Adnan"));
        accounts.put("B2", new Account("B2", "Jarin", 100000));
        accounts.put("C3", new Account("C3", "Pranto", 56800));

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Create New Account");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Transfer to Other");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Balance: ");
                    int bal = sc.nextInt();
                    accounts.put(id, new Account(id, name, bal));
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    System.out.print("Enter Account ID to credit: ");
                    String creditId = sc.nextLine();
                    if (accounts.containsKey(creditId)) {
                        System.out.print("Enter amount: ");
                        int amt = sc.nextInt();
                        accounts.get(creditId).credit(amt);
                        System.out.println("Amount credited.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account ID to debit: ");
                    String debitId = sc.nextLine();
                    if (accounts.containsKey(debitId)) {
                        System.out.print("Enter amount: ");
                        int amt = sc.nextInt();
                        accounts.get(debitId).debit(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter FROM Account ID: ");
                    String fromId = sc.nextLine();
                    System.out.print("Enter TO Account ID: ");
                    String toId = sc.nextLine();
                    if (accounts.containsKey(fromId) && accounts.containsKey(toId)) {
                        System.out.print("Enter amount to transfer: ");
                        int amt = sc.nextInt();
                        accounts.get(fromId).transferTo(accounts.get(toId), amt);
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;
                case 5:
                    System.out.println("\n Account Details ");
                    for (Account acc : accounts.values()) {
                        System.out.println(acc);
                    }
                    break;
                case 6:
                    System.out.println("Exiting!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option!!");
            }
        }
    }
}

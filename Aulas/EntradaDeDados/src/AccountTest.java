import javax.swing.*;

public class AccountTest {

    public static void main(String[] args) {

        Account account = new Account("Andrew", 1.3);

        double amount;

        amount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount for account:"));
        account.deposit(amount);
        JOptionPane.showMessageDialog(null, account.getName() + "balance: " + account.getBalance());

    }

}

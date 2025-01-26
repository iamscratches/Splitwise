import java.util.Arrays;

import manager.ExpenseManager;
import model.SplitStrategy;
import model.User;
import model.splitStrategy.EqualSplitStrategy;
import model.splitStrategy.ExactSplitStrategy;
import model.splitStrategy.PercentageSplitStrategy;

public class Main {
    public static void main(String args[]){
        ExpenseManager expenseManager = new ExpenseManager();

        User user1 = new User("1", "Alice", "alice@example.com", "1234567890");
        User user2 = new User("2", "Bob", "bob@example.com", "1234567891");
        User user3 = new User("3", "Charlie", "charlie@example.com", "1234567892");

        expenseManager.addUser(user1);
        expenseManager.addUser(user2);
        expenseManager.addUser(user3);

        // Equal Split
        SplitStrategy equalStrategy = new EqualSplitStrategy();
        expenseManager.addExpense(300, user1, Arrays.asList(user2, user3), equalStrategy, null);

        // Exact Split
        SplitStrategy exactStrategy = new ExactSplitStrategy();
        expenseManager.addExpense(300, user2, Arrays.asList(user1, user3), exactStrategy, Arrays.asList(100.0, 200.0));

        // Percentage Split
        SplitStrategy percentageStrategy = new PercentageSplitStrategy();
        expenseManager.addExpense(300, user3, Arrays.asList(user1, user2), percentageStrategy, Arrays.asList(40.0, 60.0));

        // Show balances
        expenseManager.showBalances();
    }
}

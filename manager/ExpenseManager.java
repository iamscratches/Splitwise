package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Split;
import model.SplitStrategy;
import model.User;

public class ExpenseManager {
    private Map<String, User> users;
    private Map<String, Map<String, Double>> balances;

    public ExpenseManager() {
        this.users = new HashMap<>();
        this.balances = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserID(), user);
        balances.put(user.getUserID(), new HashMap<>());
    }

    public void addExpense(double amount, User paidBy, List<User> involvedUsers, SplitStrategy strategy, List<Double> additionalData) {
        List<Split> splits = strategy.calculateSplits(amount, involvedUsers, additionalData);

        for (Split split : splits) {
            String paidTo = split.getUser().getUserID();
            double splitAmount = split.getAmount();

            balances.get(paidBy.getUserID()).put(paidTo,
                balances.getOrDefault(paidBy.getUserID(), new HashMap<>())
                        .getOrDefault(paidTo, 0.0) + splitAmount);

            balances.get(paidTo).put(paidBy.getUserID(),
                balances.getOrDefault(paidTo, new HashMap<>())
                        .getOrDefault(paidBy.getUserID(), 0.0) - splitAmount);
        }
        System.out.println(balances);
    }

    public void showBalances() {
        for (Map.Entry<String, Map<String, Double>> userBalances : balances.entrySet()) {
            for (Map.Entry<String, Double> balance : userBalances.getValue().entrySet()) {
                if (balance.getValue() != 0) {
                    System.out.println(users.get(userBalances.getKey()).getUsername() +
                        " owes " + users.get(balance.getKey()).getUsername() +
                        ": " + -balance.getValue());
                }
            }
        }
    }
}

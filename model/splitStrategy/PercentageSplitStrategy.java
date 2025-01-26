package model.splitStrategy;

import java.util.ArrayList;
import java.util.List;

import model.Split;
import model.SplitStrategy;
import model.User;
import model.split.PercentageSplit;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calculateSplits(double amount, List<User> users, List<Double> additionalData) {
        if (users.size() != additionalData.size()) {
            throw new IllegalArgumentException("Number of users and percentages must match.");
        }

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            double percentage = additionalData.get(i);
            double splitAmount = (percentage / 100) * amount;
            PercentageSplit split = new PercentageSplit(users.get(i), percentage);
            split.setAmount(splitAmount);
            splits.add(split);
        }
        return splits;
    }

}

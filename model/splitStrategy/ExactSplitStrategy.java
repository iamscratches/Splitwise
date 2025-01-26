package model.splitStrategy;

import java.util.ArrayList;
import java.util.List;

import model.Split;
import model.SplitStrategy;
import model.User;
import model.split.ExactSplit;

public class ExactSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> calculateSplits(double amount, List<User> users, List<Double> additionalData) {
        if (users.size() != additionalData.size()) {
            throw new IllegalArgumentException("Number of users and exact amounts must match.");
        }

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            ExactSplit split = new ExactSplit(users.get(i), additionalData.get(i));
            splits.add(split);
        }

        return splits;
    }

}

package model.splitStrategy;

import java.util.ArrayList;
import java.util.List;

import model.Split;
import model.SplitStrategy;
import model.User;
import model.split.EqualSplit;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calculateSplits(double amount, List<User> users, List<Double> additionalData) {
        List<Split> splits = new ArrayList<>();
        double splitAmount = amount / users.size();

        for (User user : users) {
            EqualSplit split = new EqualSplit(user);
            split.setAmount(splitAmount);
            splits.add(split);
        }

        return splits;
    }
    

}

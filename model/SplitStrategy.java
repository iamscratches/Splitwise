package model;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplits(double amount, List<User> users, List<Double> additionalData);
}

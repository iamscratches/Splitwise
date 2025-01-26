package model.split;

import model.Split;
import model.User;

public class ExactSplit extends Split{
    public ExactSplit(User user, double amount) {
        super(user);
        this.setAmount(amount);
    }
}
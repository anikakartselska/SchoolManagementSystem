package schoolproject.model;

import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class Parent {
   private HashMap<Long,Student> children=new HashMap<>();
   private double monthIncome;

    @Override
    public String toString() {
        return new StringJoiner(", ", super.toString() + "[", "]")
                .add("children=" + children)
                .toString();
    }

    public HashMap<Long, Student> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Long, Student> children) {
        this.children = children;
    }

    public double getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(double monthIncome) {
        this.monthIncome = monthIncome;
    }
}

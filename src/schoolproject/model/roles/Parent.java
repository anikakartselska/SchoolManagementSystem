package schoolproject.model.roles;

import schoolproject.dao.UserIdentifiable;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Role;

import java.util.Date;
import java.util.HashMap;
import java.util.StringJoiner;

public class Parent extends User implements UserIdentifiable {
   private HashMap<Long, Student> children=new HashMap<>();
   private double monthIncome;

    public Parent(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.setRole(Role.PARENT);
    }

    public Parent(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, HashMap<Long, Student> children, double monthIncome) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.children = children;
        this.monthIncome = monthIncome;
        this.setRole(Role.PARENT);
    }

    public Parent(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, HashMap<Long, Student> children, double monthIncome) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.children = children;
        this.monthIncome = monthIncome;
        this.setRole(Role.PARENT);
    }

    public Parent(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday) {
        super(firstName, secondName, thirdName, email, username, password, gender,  phoneNumber, address, birthday);
        this.setRole(Role.PARENT);
    }

    public Parent(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender,  HashMap<Long, Student> children) {
        super(firstName, secondName, thirdName, email, username, password, gender);
        this.children = children;
        this.setRole(Role.PARENT);
    }

    public Parent(String firstName, String secondName, String thirdName, String email, String username, String password, Gender gender, String phoneNumber, String address, Date birthday, HashMap<Long, Student> children) {
        super(firstName, secondName, thirdName, email, username, password, gender, phoneNumber, address, birthday);
        this.children = children;
        this.setRole(Role.PARENT);
    }

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

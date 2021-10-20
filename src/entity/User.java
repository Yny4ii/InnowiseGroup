package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String firstRole;
    private String secondRole;
    private String thirdRole;
    private String firstPhone;
    private String secondPhone;
    private String thirdPhone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstRole() {
        return firstRole;
    }

    public void setFirstRole(String firstRole) {
        this.firstRole = firstRole;
    }

    public String getSecondRole() {
        return secondRole;
    }

    public void setSecondRole(String secondRole) {
        this.secondRole = secondRole;
    }

    public String getThirdRole() {
        return thirdRole;
    }

    public void setThirdRole(String thirdRole) {
        this.thirdRole = thirdRole;
    }

    public String getFirstPhone() {
        return firstPhone;
    }

    public void setFirstPhone(String firstPhone) {
        this.firstPhone = firstPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public String getThirdPhone() {
        return thirdPhone;
    }

    public void setThirdPhone(String thirdPhone) {
        this.thirdPhone = thirdPhone;
    }

    public void printUser() {
        System.out.println("First name: " + this.getFirstName());
        System.out.println("Last name: " + this.getLastName());
        System.out.println("Email: " + getEmail());
        System.out.println("Role: " + getFirstRole() + " | "  + getSecondRole() + " | " + getThirdRole());
        System.out.println("Phone: " + getFirstPhone() + " | " + getSecondPhone() + " | " + getThirdPhone());
    }
}


package io;

import validators.EmailValidatorImpl;
import validators.NameValidatorImpl;
import validators.PhoneValidatorImpl;
import validators.RoleValidatorImpl;

import java.util.Locale;
import java.util.Scanner;

public class Reader {
    private final EmailValidatorImpl emailValidation;
    private final PhoneValidatorImpl phoneValidation;
    private final RoleValidatorImpl roleValidator;
    private final NameValidatorImpl nameValidator;
    private final Scanner scanner = new Scanner(System.in);
    private boolean exist = true;


    public Reader(EmailValidatorImpl emailValidation, PhoneValidatorImpl phoneValidation, RoleValidatorImpl roleValidator, NameValidatorImpl nameValidator) {
        this.emailValidation = emailValidation;
        this.phoneValidation = phoneValidation;
        this.roleValidator = roleValidator;
        this.nameValidator = nameValidator;
    }


    public String readEmail() {
        while (exist) {
            String email = scanner.nextLine();
            if (emailValidation.check(email)) {
                return email;
            } else {
                System.out.println("Invalid email, try again");
            }
        }
        return null;
    }

    public String readRole(int roleLevel) {
        while (exist) {
            String role = scanner.nextLine();
            if (role.equalsIgnoreCase("N")) {
                return null;
            } else if (roleValidator.isAcceptableRole(role, roleLevel)) {
                return role.toUpperCase(Locale.ROOT);
            }
            System.out.println("Invalid role, try again");
        }
        return null;
    }


    public String readPhone(boolean isFirstNumber) {
        while (exist) {
            String phone = scanner.nextLine();
            if (phone != null) {
                if (!isFirstNumber && "N".equalsIgnoreCase(phone)) {
                    return null;
                }
                if (phoneValidation.check(phone)) {
                    return phone.replaceAll("\\s+", "");
                }
            }
            System.out.println("Invalid request, try again.");
        }
        return null;
    }

    public String readName() {
        while (true) {
            String name = scanner.nextLine();
            if (nameValidator.check(name)) {
                return name;
            } else {
                System.out.println("Invalid name, try again");
            }
        }
    }
}


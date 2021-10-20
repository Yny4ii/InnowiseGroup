package validators;

public class EmailValidatorImpl implements Validator<String> {
    @Override
    public boolean check(String email) {
        return email != null && email.matches("\\b\\w+@\\w+\\.\\w+\\b");
    }
}

package validators;

public class NameValidatorImpl implements Validator<String> {
    @Override
    public boolean check(String userName) {
        return userName != null && userName.matches("\\w+");
    }
}

package validators;

public class PhoneValidatorImpl implements Validator<String> {
    @Override
    public boolean check(String phone) {
        return phone.replaceAll("\\s+", "").matches("375\\d{5,}");
    }
}

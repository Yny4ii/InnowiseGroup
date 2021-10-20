import io.Reader;
import repository.UserRepository;
import service.RoleService;
import service.UserService;
import validators.EmailValidatorImpl;
import validators.NameValidatorImpl;
import validators.PhoneValidatorImpl;
import validators.RoleValidatorImpl;

import java.util.Scanner;

public class Main {
    private static final String PATH = "YOUR PATH";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailValidatorImpl emailValidatorImpl = new EmailValidatorImpl();
        PhoneValidatorImpl phoneValidator = new PhoneValidatorImpl();
        RoleValidatorImpl roleValidator = new RoleValidatorImpl();
        NameValidatorImpl nameValidator = new NameValidatorImpl();
        RoleService roleService = new RoleService();
        UserRepository userRepository = new UserRepository();
        Reader reader = new Reader(emailValidatorImpl, phoneValidator, roleValidator, nameValidator);

        UserService userService = new UserService(reader, roleService, userRepository);


        boolean exit = false;

        try {
            userRepository.loadRepository(PATH);
            while (!exit) {
                System.out.println("""
                        1 - create new user
                        2 - update user by id
                        3 - delete user by id
                        4 - show users
                        5 - exit""");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1 -> userService.createUser();
                    case 2 -> userService.editUserById();
                    case 3 -> userService.deleteUserById();
                    case 4 -> userService.showUsers();
                    case 5 -> exit = true;
                    default -> System.out.println("Unexpected value: " + choose);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            userRepository.saveRepository(PATH);
        }

    }
}

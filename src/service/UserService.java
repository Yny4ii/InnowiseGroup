package service;

import entity.User;
import io.Reader;
import repository.UserRepository;

import java.util.Map;
import java.util.Scanner;

public class UserService {
    private final Reader reader;
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final Scanner scanner = new Scanner(System.in);


    public UserService(Reader reader, RoleService roleService, UserRepository userRepository) {
        this.reader = reader;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    private User readUser() {
        User user = new User();

        System.out.println("First name: ");
        user.setFirstName(reader.readName());
        System.out.println("Last name: ");
        user.setLastName(reader.readName());

        System.out.println("Email: ");
        user.setEmail(reader.readEmail());

        System.out.println("Choose role: ");
        roleService.printRoles();
        System.out.println("\nChoose first-level role, for choosing nothing type \"N\":");
        String firstLevelRole = reader.readRole(1);
        user.setFirstRole(firstLevelRole);

        System.out.println("Choose second-level role, for choosing nothing type \"N\":");
        String secondLevelRole = reader.readRole(2);
        user.setSecondRole(secondLevelRole);

        if (user.getFirstRole() == null && user.getSecondRole() == null) {
            System.out.println("Choose third-level role, for choosing nothing type \"N\":");
            String thirdLevelRole = reader.readRole(3);
            user.setThirdRole(thirdLevelRole);
        } else {
            user.setThirdRole(null);
        }


        System.out.println("Type first number:");
        user.setFirstPhone(reader.readPhone(true));
        System.out.println("Type second number, for choosing nothing type \"N\":");
        user.setSecondPhone(reader.readPhone(false));
        if (user.getSecondPhone() != null) {
            System.out.println("Type third number, for choosing nothing type \"N\":");
            user.setThirdPhone(reader.readPhone(false));
        }
        System.out.println(user);
        return user;

    }

    public void createUser() {
        User user = readUser();
        userRepository.addUser(user);
    }

    public void showUsers() {
        Map<Integer, User> userMap = userRepository.getUserMap();
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            System.out.println("User id: " + entry.getKey());
            entry.getValue().printUser();
            System.out.println("******************************");
        }
    }

    public void editUserById() {
        System.out.println("Enter user id");
        int id = scanner.nextInt();
        System.out.println("Enter new data");
        User user = readUser();
        userRepository.setUser(id, user);
    }

    public void deleteUserById() {
        System.out.println("Enter user id");
        int id = scanner.nextInt();
        userRepository.removeUser(id);
    }

}

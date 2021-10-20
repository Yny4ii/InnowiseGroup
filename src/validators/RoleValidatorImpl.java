package validators;

import service.RoleService;

import java.util.HashMap;
import java.util.Map;

public class RoleValidatorImpl implements Validator<String> {
    RoleService roleService = new RoleService();


    @Override
    public boolean check(String userRole) {
        HashMap<String, Integer> roles = roleService.getRoles();
        for (Map.Entry<String, Integer> entry : roles.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(userRole)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAcceptableRole(String role, int level) {
        for (Map.Entry<String, Integer> entry : roleService.getRoles().entrySet()) {
            if (entry.getValue() == level && entry.getKey().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}

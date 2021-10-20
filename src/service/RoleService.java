package service;

import entity.Role;

import java.util.HashMap;

public class RoleService {
    public HashMap<String, Integer> getRoles() {
        HashMap<String, Integer> roles = new HashMap<>();
        Role[] array = Role.values();
        for (Role role : array) {
            roles.put(role.toString(), role.getRoleLevel());
        }
        return roles;
    }


    public void printRoles() {
        Role[] array = Role.values();
        for (Role role : array) {
            System.out.println(role.toString() + " - " + role.getRoleLevel());
        }
    }
}

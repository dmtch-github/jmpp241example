package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    private Map<String, User> userMap = new HashMap<String, User>();

    private UserDaoImpl() {
        // name - уникальное значение, выступает в качестве ключа Map
        userMap.put("test",
                new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER"))));
        userMap.put("dima",
                new User(2L, "dima", "dima", Collections.singleton(new Role(1L, "ROLE_USER"))));
        userMap.put("dima21",
                new User(3L, "dima21", "dima21", Collections.singleton(new Role(2L, "ROLE_ADMIN"))));

        Set<Role> set = new HashSet<Role>();
        Collections.addAll(set, new Role(1L,"ROLE_USER"), new Role( 2L,"ROLE_ADMIN"));
        userMap.put("dimax",
                new User(3L, "dimax", "dimax", set));

    }


    @Override
    public User getUserByName(String name) {

        System.out.println("Проверяю пользователя с ключом \"" + name + "\"");

        if (!userMap.containsKey(name)) {
            return null;
        }

        User user = userMap.get(name);

        System.out.println(user);

        return user;
    }
}


package opera.service.impl;

import java.util.Set;
import opera.model.Role;
import opera.model.User;
import opera.service.AuthenticationService;
import opera.service.RoleService;
import opera.service.ShoppingCartService;
import opera.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.USER)));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}

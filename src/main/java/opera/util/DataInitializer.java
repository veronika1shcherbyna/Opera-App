package opera.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import opera.model.Role;
import opera.model.User;
import opera.service.RoleService;
import opera.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService,
                           UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@i.ua");
        user.setPassword("admin123");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}

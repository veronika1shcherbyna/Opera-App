package opera.dao;

import java.util.Optional;
import opera.model.Role;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}

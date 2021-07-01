package opera.service;

import opera.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}

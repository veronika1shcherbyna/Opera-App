package opera.service;

import opera.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}

package opera.service;

import opera.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}

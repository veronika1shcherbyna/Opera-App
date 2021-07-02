package opera.service;

import opera.model.PerformanceSession;
import opera.model.ShoppingCart;
import opera.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}

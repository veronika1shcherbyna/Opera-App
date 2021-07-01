package opera.service;

import java.util.List;
import opera.model.Order;
import opera.model.ShoppingCart;
import opera.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}

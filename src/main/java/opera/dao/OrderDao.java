package opera.dao;

import java.util.List;
import opera.model.Order;
import opera.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}

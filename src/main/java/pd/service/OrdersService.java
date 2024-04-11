package pd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.entity.Orders;
import pd.repository.OrdersRepository;

import java.time.LocalDateTime;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public String placeOrder (Orders orders) {
        orders.setLdt(LocalDateTime.now());

        ordersRepository.save(orders);
        return "Order for product " +orders.getPid() + " has been successfully placed";
    }
}

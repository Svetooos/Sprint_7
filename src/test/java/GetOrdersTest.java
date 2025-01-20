import data.order.GetOrderResponse;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import api.OrdersApi;

import static org.junit.Assert.*;

public class GetOrdersTest {

    OrdersApi ordersApi = new OrdersApi();

    @Test
    @DisplayName("Получение списка заказов")
    public void getOrders_success() {
        GetOrderResponse orders = ordersApi.getOrders();
        assertNotNull(orders.getOrders());
        assertNotNull(orders.getOrders().getId());
    }
}

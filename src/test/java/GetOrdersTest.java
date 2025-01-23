import data.order.GetOrderResponse;
import data.order.Orders;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import api.OrdersApi;

import java.util.List;

import static org.junit.Assert.*;

public class GetOrdersTest {

    OrdersApi ordersApi = new OrdersApi();

    @Test
    @DisplayName("Получение списка заказов")
    public void getOrders_success() {
        GetOrderResponse orderResponse = ordersApi.getOrders();
        assertNotNull(orderResponse);
        Orders[] orders = orderResponse.getOrders();
        assertTrue(orders != null && orders.length > 0);
        assertNotNull(orders[0].getId());
    }
}

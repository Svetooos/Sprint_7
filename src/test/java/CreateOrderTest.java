import data.order.CreateOrderResponse;
import data.order.CreateOrderRequest;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import api.OrdersApi;
import data.BaseResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private OrdersApi orderApi = new OrdersApi();
    private Integer track;
    private final String[] color;

    public CreateOrderTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] result() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}},};
    }

    @Test
    @DisplayName("Оформление заказа - разные цвета")
    public void createOrder_colorsParameterized() {
        CreateOrderRequest request = new CreateOrderRequest(
                RandomStringUtils.randomAlphabetic(8),
                RandomStringUtils.randomAlphabetic(8),
                RandomStringUtils.randomAlphabetic(8),
                1,
                "+7 800 111 11 11",
                1,
                "2024-10-10",
                RandomStringUtils.randomAlphabetic(8),
                color);
        CreateOrderResponse response = orderApi.orderCreate(request);
        assertNotNull(response.getTrack());
        track = response.getTrack();
    }

    @After
    public void endTest() {
        BaseResponse response = orderApi.cancel(track);
        assertEquals(true, response.getOk());
    }
}
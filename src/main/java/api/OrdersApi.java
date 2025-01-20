package api;

import data.order.CreateOrderResponse;
import data.order.CreateOrderRequest;
import data.BaseResponse;
import data.order.GetOrderResponse;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class OrdersApi extends BaseHttpClient {

    private final static String ORDER_BASE_PATH = "/api/v1/orders";
    private final static String ORDER_CANCEL_PATH = ORDER_BASE_PATH + "/cancel?track=";

    public CreateOrderResponse orderCreate(CreateOrderRequest createOrderRequest) {
        return doPostRequest(ORDER_BASE_PATH, createOrderRequest).as(CreateOrderResponse.class);
    }

    public GetOrderResponse getOrders() {
        Response ordersModel = doGetRequest(ORDER_BASE_PATH);
        return ordersModel.as(GetOrderResponse.class);
    }

    public BaseResponse cancel(Integer value) {
        Map<String, Integer> params = new HashMap<>();
        params.put("track", value);
        String cancelPath = ORDER_CANCEL_PATH + value;
        return doPutRequest(cancelPath, params).as(BaseResponse.class);
    }
}

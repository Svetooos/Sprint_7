package api;

import data.courier.Courier;
import data.BaseResponse;

public class CourierApi extends BaseHttpClient {

    private final static String COURIER_BASE_PATH = "/api/v1/courier";
    private final static String COURIER_LOGIN_PATH = COURIER_BASE_PATH + "/login";

    public BaseResponse create(Courier courier) {
        return doPostRequest(COURIER_BASE_PATH, courier).as(BaseResponse.class);
    }

    public void delete(Integer courierId) {
        String deletePath = COURIER_BASE_PATH + courierId;
        doDeleteRequest(deletePath);
    }

    public BaseResponse login(Courier courier) {
        return doPostRequest(COURIER_LOGIN_PATH, courier).as(BaseResponse.class);
    }

}

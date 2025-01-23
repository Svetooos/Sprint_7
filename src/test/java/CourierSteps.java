import data.courier.Courier;
import io.qameta.allure.Step;
import api.CourierApi;
import data.BaseResponse;

import static org.junit.Assert.assertEquals;

public class CourierSteps {

    private final CourierApi courierApi = new CourierApi();

    @Step
    public void createCourier_success(Courier courier) {
        BaseResponse expected = new BaseResponse(true);
        BaseResponse actual = courierApi.create(courier);
        assertEquals(expected.getOk(), actual.getOk());
    }

    @Step
    public void createCourier_missData(Courier courier) {
        BaseResponse expected = new BaseResponse(400, "Недостаточно данных для создания учетной записи");
        BaseResponse actual = courierApi.create(courier);
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getMessage(), actual.getMessage());
    }

    @Step
    public void createCourier_duplicate(Courier courier) {
        BaseResponse expected = new BaseResponse(409, "Этот логин уже используется. Попробуйте другой.");
        courierApi.create(courier);
        BaseResponse actual = courierApi.create(courier);
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getMessage(), actual.getMessage());
    }

    @Step
    public void loginCourier_success(Courier courier) {
        courierApi.login(courier);
    }

    @Step
    public void loginCourier_unsuccessful(Courier courier) {
        BaseResponse expected = new BaseResponse(404, "Учетная запись не найдена");
        BaseResponse actual = courierApi.login(courier);
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getMessage(), actual.getMessage());
    }

    @Step
    public void loginCourier_missData(Courier courier) {
        BaseResponse actual = courierApi.login(courier);
        BaseResponse expected = new BaseResponse(400, "Недостаточно данных для входа");
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getMessage(), actual.getMessage());
    }

    @Step
    public void deleteCourier(Courier courier) {
        courierApi.delete(courier.getId());
    }
}


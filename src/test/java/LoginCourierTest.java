import data.courier.Courier;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginCourierTest {

    private Courier courier;
    CourierSteps courierSteps = new CourierSteps();

    @Before
    public void setUp() {
        courier = new Courier(
                RandomStringUtils.randomAlphabetic(8),
                RandomStringUtils.randomAlphabetic(8),
                RandomStringUtils.randomAlphabetic(8));
        courierSteps.createCourier_success(courier);
    }

    @After
    public void endTest() {
        courierSteps.deleteCourier(courier);
    }

    @Test
    @DisplayName("Авторизация курьера - успех")
    public void loginCourier_success() {
        courierSteps.loginCourier_success(courier);
    }

    @Test
    @DisplayName("Авторизация курьера - пустой пароль")
    public void loginCourier_missPassword() {
        courier.setPassword(StringUtils.EMPTY);
        courierSteps.loginCourier_missData(courier);
    }

    @Test
    @DisplayName("Авторизация курьера - пустой логин")
    public void loginCourier_missLogin() {
        courier.setLogin(StringUtils.EMPTY);
        courierSteps.loginCourier_missData(courier);
    }

    @Test
    @DisplayName("Авторизация курьера - некорректный пароль")
    public void loginCourier_incorrectPassword() {
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps.loginCourier_unsuccessful(courier);
    }

    @Test
    @DisplayName("Авторизация курьера - некорректный логин")
    public void loginCourier_incorrectLogin() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        courierSteps.loginCourier_unsuccessful(courier);
    }
}

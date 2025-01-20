import data.courier.Courier;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateCourierTest {

    private final CourierSteps courierSteps = new CourierSteps();
    private Courier courier = new Courier(
            RandomStringUtils.randomAlphabetic(8),
            RandomStringUtils.randomAlphabetic(8),
            RandomStringUtils.randomAlphabetic(8));

    @Before
    public void setUp() {
        courierSteps.loginCourier_success(courier);
    }

    @After
    public void endTest() {
        courierSteps.deleteCourier(courier);
    }

    @Test
    @DisplayName("Создание курьера - успех")
    public void createCourier_success() {
        courierSteps.createCourier_success(courier);
    }

    @Test
    @DisplayName("Создание курьера - пустой пароль")
    public void createCourier_missPassword() {
        courier.setPassword(null);
        courierSteps.createCourier_missData(courier);
    }

    @Test
    @DisplayName("Создание курьера - пустой логин")
    public void createCourier_missLogin() {
        courier.setLogin(null);
        courierSteps.createCourier_missData(courier);
    }

    @Test
    @DisplayName("Создание дубликата курьера")
    public void createCourier_duplicate() {
        courierSteps.createCourier_duplicate(courier);
    }
}

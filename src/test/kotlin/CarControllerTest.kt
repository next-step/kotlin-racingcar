import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarControllerTest {

    @DisplayName("자동차 객체 생성 테스트")
    @Test
    fun makeCar() {
        val carController = CarController()
        val cars = carController.makeCars(3)

        assertThat(cars.size).isEqualTo(3)
    }

    @DisplayName("자동차 목록 1사이클 테스트")
    @Test
    fun playCar() {
    }
}

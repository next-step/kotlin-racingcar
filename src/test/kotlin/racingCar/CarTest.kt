package racingCar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @DisplayName(value = "입력된 숫자가 4 이상이면 전진한다.")
    @Test
    fun `car move`() {
        car.move(4)
        assertThat(car.distance).isEqualTo(1)
    }

    @DisplayName(value = "입력된 숫자가 4 이하면 움직이지 않는다.")
    @Test
    fun name() {
        car.move(1)
        assertThat(car.distance).isEqualTo(0)
    }
}

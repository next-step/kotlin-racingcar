package step3.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racingcar.car.Car
import step3.racingcar.car.Driver

class DriverTest {

    @Test
    fun `4 이상 숫자가 나오면 움직인다`() {
        val moveNumber = 5
        val nonMoveNumber = 3
        val boundaryNumber = 4

        val driver = Driver(Car())

        assertThat(driver.isMovable(moveNumber)).isTrue
        assertThat(driver.isMovable(nonMoveNumber)).isFalse
        assertThat(driver.isMovable(boundaryNumber)).isTrue
    }
}

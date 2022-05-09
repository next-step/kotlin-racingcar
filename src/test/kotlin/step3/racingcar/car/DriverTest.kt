package step3.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DriverTest {

    @Test
    fun `4 이상 숫자가 나오면 움직인다`() {
        // given
        val driver = Driver(Car())
        val moveNumber = 5
        val nonMoveNumber = 3
        val boundaryNumber = 4

        driver.drive(moveNumber)
        assertThat(driver.getMoveResult()).isEqualTo(1)

        driver.drive(nonMoveNumber)
        assertThat(driver.getMoveResult()).isEqualTo(1)

        driver.drive(boundaryNumber)
        assertThat(driver.getMoveResult()).isEqualTo(2)
    }
}

package step3.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racingcar.car.Car
import step3.racingcar.car.Driver
import step3.racingcar.car.Position

class DriverTest {

    @Test
    fun `4 이상 숫자가 나오면 움직인다`() {
        // given
        val driver = Driver(Car())
        val moveNumber = 5

        // when
        driver.drive(moveNumber)

        // then
        assertThat(driver.getDriveResult().last()).isEqualTo(Position.MOVE)

        // when
        val nonMoveNumber = 3
        driver.drive(nonMoveNumber)

        // then
        assertThat(driver.getDriveResult().last()).isEqualTo(Position.STOP)

        val boundaryNumber = 4
        driver.drive(boundaryNumber)

        // then
        assertThat(driver.getDriveResult().last()).isEqualTo(Position.MOVE)
    }
}

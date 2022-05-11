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

    @Test
    fun `드라이버가 차의 현재 위치 값을 받는다`() {
        // given
        val testCar = Car()
        val testDriver = Driver(testCar)

        // when
        for (i in 0 until 100) {
            if (i / 2 == 0) {
                testCar.move()
            } else {
                testCar.stop()
            }
        }

        assertThat(testDriver.getMoveResult()).isEqualTo(testCar.currentDrivingRecord)
    }
}

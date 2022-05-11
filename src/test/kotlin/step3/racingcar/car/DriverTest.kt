package step3.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racingcar.car.strategy.MoveStrategy

class DriverTest {

    @Test
    fun `드라이버의 전략이 true면 차가 움직일 수 있다`() {
        // given
        val alwayMoveDriver = Driver(Car(), AlwaysTrueMoveStrategy())

        // when
        val moveCount = 100
        repeat(moveCount) {
            alwayMoveDriver.drive()
        }

        // then
        assertThat(alwayMoveDriver.getMoveResult()).isEqualTo(100)
    }

    @Test
    fun `드라이버의 전략이 false면 차가 움직일 수 있다`() {
        // given
        val alwayMoveDriver = Driver(
            Car(),
            object : MoveStrategy {
                override fun isMovable(): Boolean {
                    return false
                }
            }
        )

        // when
        val moveCount = 100
        repeat(moveCount) {
            alwayMoveDriver.drive()
        }

        // then
        assertThat(alwayMoveDriver.getMoveResult()).isEqualTo(0)
    }

    @Test
    fun `드라이버는 차의 현재 위치 값을 알 수 있다`() {
        // given
        val testCar = Car()
        val testDriver = Driver(testCar, AlwaysTrueMoveStrategy())

        // when
        for (i in 0 until 100) {
            if (i / 2 == 0) {
                testCar.move()
            }
        }
        assertThat(testDriver.getMoveResult()).isEqualTo(testCar.currentDrivingRecord)
    }
}

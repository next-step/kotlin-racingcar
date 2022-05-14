package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차 이동을 실행한다 예측한 이동결과와 동일한지 확인한다`() {
        // given
        val testCar = Car("testCar")

        // when
        testCar.move()

        // then
        val moveResult = MoveResults.MoveResult("testCar", 1)

        assertThat(testCar.moveResult.carName).isEqualTo(moveResult.carName)
        assertThat(testCar.moveResult.moveDistance).isEqualTo(moveResult.moveDistance)
        assertThat(testCar.moveResult).isEqualTo(moveResult)
    }
}

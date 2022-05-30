package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.engine.ConstantEngine

class CarTest {
    @Test
    fun `자동차는 이동횟수마다 엔진이 제공하는 전진 포인트만큼 이동한다`() {
        val advancePoint = 2
        val car = Car(ConstantEngine(advancePoint))
        for (moveCount in 1..10) {
            val position = car.positionBy(moveCount)
            Assertions.assertThat(position == advancePoint * moveCount).isTrue
        }
    }
}

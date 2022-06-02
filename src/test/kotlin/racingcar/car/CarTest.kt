package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.car.engine.ConstantEngine

class CarTest {
    @Test
    fun `자동차는 이동횟수마다 엔진이 제공하는 전진 포인트만큼 이동한다`() {
        val advancePoint = 2
        val car = Car(ConstantEngine(advancePoint))
        for (moveCount in 1..10) {
            val position = car.positionBy(moveCount)
            assertThat(position == advancePoint * moveCount).isTrue
        }
    }

    @Test
    fun `자동차는 이름값을 갖는다`() {
        val name = "자동차 이름"
        val car = Car(ConstantEngine(1), name)
        assertThat(car.name).isEqualTo(name)
    }
}

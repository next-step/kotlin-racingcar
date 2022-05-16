package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `이동횟수에 따른 포지션 값을 얻을 수 있고, 해당 포지션은 항상 이전 포지션 이상이다`() {
        for (moveCount in 1..10) {
            val car = Car(moveCount)
            List(moveCount) { it + 1 }.forEach { step ->
                val currentPosition = car.positionBy(step)
                val beforePosition = car.positionBy(step - 1)
                Assertions.assertThat(currentPosition >= beforePosition).isTrue
            }
        }
    }
}

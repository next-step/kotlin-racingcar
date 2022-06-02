package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.car.engine.ConstantEngine

class GameBoardTest {
    @Test
    fun `자동차 리스트로부터 우승 자동차 리스트를 얻을 수 있다`() {
        val carA = Car(ConstantEngine(1), "A")
        val carB = Car(ConstantEngine(3), "B")
        val carC = Car(ConstantEngine(2), "C")
        val carD = Car(ConstantEngine(3), "D")
        val cars = listOf(carA, carB, carC, carD)
        val expected = listOf(carB, carD)
        assertThat(getWinners(cars, 10)).isEqualTo(expected)
    }
}

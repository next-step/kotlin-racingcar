package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.car.engine.ConstantEngine

class RefereeTest {
    @Test
    fun `우승 자동차의 위치값을 구할 수 있다`() {
        val carA = Car(ConstantEngine(1), "A")
        val carB = Car(ConstantEngine(3), "B")
        val carC = Car(ConstantEngine(2), "C")
        val carD = Car(ConstantEngine(3), "D")
        val cars = listOf(carA, carB, carC, carD)
        val moveCount = 10
        val referee = Referee(cars, moveCount)
        val expected = 30
        Assertions.assertThat(referee.getWinnersPosition()).isEqualTo(expected)
    }

    @Test
    fun `우승 자동차 리스트를 얻을 수 있다`() {
        val carA = Car(ConstantEngine(1), "A")
        val carB = Car(ConstantEngine(3), "B")
        val carC = Car(ConstantEngine(2), "C")
        val carD = Car(ConstantEngine(3), "D")
        val cars = listOf(carA, carB, carC, carD)
        val moveCount = 10
        val referee = Referee(cars, moveCount)
        val expected = listOf(carB, carD)
        Assertions.assertThat(referee.getWinners()).isEqualTo(expected)
    }
}

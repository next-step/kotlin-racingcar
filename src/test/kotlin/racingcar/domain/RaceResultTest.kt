package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceResultTest {

    @Test
    @DisplayName("A자동차와 B자동차 중 A자동차가 가장 멀리 감")
    fun `Out of cars A and B, car A is the farthest away`() {
        val carA = Car("A", 5)
        val carB = Car("B")

        val cars = listOf(carA, carB)
        val raceResult = RaceResult(cars)

        Assertions.assertThat(raceResult.winnerCars.contains(carA)).isTrue
    }
}

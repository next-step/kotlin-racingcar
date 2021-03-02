package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarsTest {
    @Test
    fun `자동차 경주가 진행하여 자동차들의 위치들을 리턴한다`() {
        val cars = Cars(listOf(Car(), Car(), Car()))
        val racingCars = RacingCars(cars)

        val carPositions = racingCars.racing(5)

        val firstRound = carPositions[0]

        assertAll(
            { assertThat(carPositions.size).isEqualTo(5) },
            { assertThat(firstRound[0]).isGreaterThanOrEqualTo(0) },
            { assertThat(firstRound[1]).isGreaterThanOrEqualTo(0) },
            { assertThat(firstRound[2]).isGreaterThanOrEqualTo(0) }
        )
    }
}

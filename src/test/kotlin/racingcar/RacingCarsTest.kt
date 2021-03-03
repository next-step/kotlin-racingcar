package racingcar

import fixture.CarFixture.CARS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarsTest {
    @Test
    fun `자동차 경주가 진행하여 자동차들의 위치들을 리턴한다`() {
        val cars = Cars(CARS)
        val racingCars = RacingCars(cars)

        val carPositions = racingCars.racing(5)

        val firstRound = carPositions[0]

        assertAll(
            { assertThat(carPositions.size).isEqualTo(5) },
            { assertThat(firstRound.getByIndex(0)).isNotNull() },
            { assertThat(firstRound.getByIndex(1)).isNotNull() },
            { assertThat(firstRound.getByIndex(2)).isNotNull() }
        )
    }
}

package racing.car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.car.util.RandomGenerator

class RacingTrackTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1, 2, 1",
            "3, 2, 1",
            "4, 2, 3",
            "5, 3, 4",
        ],
        delimiter = ','
    )
    fun race(input: Int, numberOfRounds: Int, expected: Int) {
        val randomGenerator = RandomGenerator { input }
        val racingTrack = RacingTrack(randomGenerator)
        val racingCars = listOf(RacingCar(), RacingCar())
        racingTrack.race(racingCars, numberOfRounds)
        assertThat(racingCars.component1().position).isEqualTo(expected)
        assertThat(racingCars.component2().position).isEqualTo(expected)
    }
}

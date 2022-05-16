package racingcar.race

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `주어진 carCount 에 따라 carList 사이즈가 결정된다`() {
        for (carCount in 1..10) {
            val race = Race(carCount, 5)
            Assertions.assertThat(race.cars.size).isEqualTo(carCount)
        }
    }
}

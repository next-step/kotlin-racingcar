package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `race runs for given rounds`() {
        val random = 5
        val race = Race(3, 5) { random }
        race.run()
        assertThat(race.cars.all { it.position == 5 }).isTrue
    }
}

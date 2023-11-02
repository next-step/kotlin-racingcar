package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.assertj.core.api.Java6Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RaceTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "3, 3, 0",
            "3, 6, 0",
            "3, 9, 0",
            "4, 3, 3",
            "4, 6, 6",
            "4, 9, 9",
            "6, 100, 100",
        ],
    )
    fun `race runs for given rounds`(randomValue: Int, rounds: Int, expectedPosition: Int) {
        val race = Race(listOf("hong", "lee", "kim"), rounds) { randomValue }
        race.run {}
        assertThat(race.cars.list.all { it.position == expectedPosition }).isTrue
    }

    @Test
    fun `should throw exception when number of rounds is negative`() {
        assertThatThrownBy {
            Race(listOf("hong", "lee", "kim"), -5)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Number of rounds must be positive")
    }
}

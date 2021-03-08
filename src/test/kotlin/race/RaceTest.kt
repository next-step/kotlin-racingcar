package race

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import race.domain.Race

class RaceTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "-1:5:car count is positive.",
            "2:-5:lap count is positive."
        ],
        delimiter = ':'
    )
    fun `illegal argument test`(carCount: Int, lapCount: Int, exception: String) {
        Assertions.assertThatThrownBy { Race(carCount, lapCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(exception)
    }

    @Test
    fun `create race test`() {

        // GIVEN
        val carCount = 2
        val lapCount = 5

        // WHEN
        val race = Race(carCount, lapCount)

        // THEN
        assertThat(race).isNotNull
        assertThat(race.cars.size).isEqualTo(carCount)
        race.cars.forEach {
            assertThat(it.position).isBetween(0, lapCount)
        }
    }
}

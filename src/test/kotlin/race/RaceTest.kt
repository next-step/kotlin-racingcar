package race

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import race.domain.Race

class RaceTest {

    @Test
    fun `illegal argument test`() {

        // GIVEN
        val carNames = "pobi,crong"
        val lapCount = -5

        // WHEN
        Assertions.assertThatThrownBy { Race(carNames, lapCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("lap count is positive.")
    }

    @Test
    fun `create race test`() {

        // GIVEN
        val carNames = "pobi,crong"
        val lapCount = 5

        // WHEN
        val race = Race(carNames, lapCount)

        // THEN
        assertThat(race).isNotNull

        race.cars.forEach {
            assertThat(it.name).isIn(carNames.split(Race.delimeter))
            assertThat(it.position).isBetween(0, lapCount)
        }
    }
}

package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceMainTests {

    @Test
    fun `trying toInt() from null`() {
        val raceRounds = 5
        val carCount = 2
        val raceSeries = RaceSeries(carCount, raceRounds)
        val result = raceSeries.start()

        assertThat(result.size).isEqualTo(raceRounds)
        assertThat(result.first().raceResult.size).isEqualTo(carCount)
    }

}
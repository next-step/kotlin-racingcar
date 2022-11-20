package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import support.Support

class RaceTest {
    private val fixture = Support.fixture

    @Test
    fun `경주 성공`() {
        // Arrange
        val carCount = 3
        val tryCount = 5
        val carNames: List<String> = fixture<List<String>> { repeatCount { carCount } }
            .map { it.slice(0..4) }

        val record = Record.from(carNames)
        val randomNumberGenerator = RandomNumberGenerator()
        val race = Race(randomNumberGenerator, record)

        // Act
        val records = race.start(carNames, tryCount)

        // Assert
        assertThat(carCount).isEqualTo(records.raceRecords.keys.size)
        assertThat(tryCount).isEqualTo(records.raceRecords.values.first().size)
        assertThat(carNames.first()).isIn(records.raceRecords.keys)
    }
}

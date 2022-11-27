package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import support.Support

class RaceTest {

    @Test
    fun `경주 성공`() {
        // Arrange
        val carCount = 3
        val tryCount = 5
        val carNames: List<String> = listOf("a", "b", "c")

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

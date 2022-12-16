package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class RaceTest {

    @Test
    fun `경주 성공`() {
        // Arrange
        val tryCount = 5
        val carNames: List<String> = listOf("a", "b", "c")

        val randomNumberGenerator = RandomNumberGenerator()
        val race = Race(randomNumberGenerator)

        // Act
        val record = race.start(carNames, tryCount)

        // Assert
        assertAll(
            Executable { assertThat(carNames.size).isEqualTo(record.raceRecords.first().carNames.size) },
            Executable { assertThat(tryCount).isEqualTo(record.raceRecords.last().round + 1) },
            Executable { assertThat(carNames.first()).isIn(record.raceRecords.first().carNames) }
        )
    }
}

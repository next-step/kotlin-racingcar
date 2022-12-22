package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

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
            { assertThat(record.lastRound + 1).isEqualTo(tryCount) },
            { assertThat(record.getSnapshotsByRound(0).size).isEqualTo(carNames.size) }
        )
    }
}

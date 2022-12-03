package race

import org.assertj.core.api.Assertions.assertThat
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
        val snapShots = race.start(carNames, tryCount)
        val record = Record(snapShots)

        // Assert
        assertThat(carNames.size).isEqualTo(record.raceRecords.first().movedCars.size)
        assertThat(tryCount).isEqualTo(record.raceRecords.last().round + 1)
        assertThat(carNames.first()).isIn(record.raceRecords.first().movedCars.map { it.name })
    }
}

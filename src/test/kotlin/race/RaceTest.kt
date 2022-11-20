package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `경주 성공`() {
        // Arrange
        val carCount = 3
        val tryCount = 5

        val record = Record.from(carCount)
        val randomNumberGenerator = RandomNumberGenerator()
        val race = Race(randomNumberGenerator, record)

        // Act
        val records = race.start(carCount, tryCount)

        // Assert
        assertThat(carCount).isEqualTo(records.size)
        assertThat(tryCount).isEqualTo(records[records.keys.first()]!!.size)
    }
}

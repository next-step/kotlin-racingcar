package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    private val race: Race = Race()

    @Test
    fun `경주 성공`() {
        // Arrange
        val carCount = 3
        val tryCount = 5

        // Act
        val cars = race.start(carCount, tryCount)

        // Assert
        assertThat(carCount).isEqualTo(cars.size)
        assertThat(tryCount).isEqualTo(cars.first().movedDistance.size)
    }
}

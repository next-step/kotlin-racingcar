package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositionTest {

    @DisplayName("Position이 바뀌면 값이 1 증가한다")
    @Test
    fun `sut returns 1 when change position`() {
        // Arrange
        val sut = Position()

        // Act
        val newPosition = sut.change()

        // Assert
        assertThat(newPosition.value).isEqualTo(1)
    }
}

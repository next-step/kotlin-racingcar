package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @DisplayName("자동차는 전진할 수 있다.")
    @Test
    fun `sut returns true when can drive`() {
        // Arrange
        val sut = Car()

        // Act
        val result = sut.isDrive()

        // Assert
        assertThat(result).isTrue
    }
}

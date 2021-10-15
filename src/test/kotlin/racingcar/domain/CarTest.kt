package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @DisplayName("자동차는 전진할 수 있다")
    @Test
    fun `sut returns true when can drive`() {
        // Arrange
        val sut = Car()

        // Act
        val result = sut.canDrive()

        // Assert
        assertThat(result).isTrue
    }

    @DisplayName("자동차가 전진하면 위치가 변경된다")
    @Test
    fun `sut returns increase position when can drive`() {
        // Arrange
        val sut = Car()
        val originalPosition = sut.position

        // Act
        val droveCar = sut.drive()

        // Assert
        assertThat(droveCar.position.value).isGreaterThan(originalPosition.value)
        assertThat(droveCar.position.value).isEqualTo(1)
    }
}

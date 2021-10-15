package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NumberTest {

    @DisplayName("input은 2 이상의 수 부터 들어올 수 있다")
    @Test
    fun `sut returns correctly`() {
        // Arrange
        val input = 2

        // Act
        val sut = Number(input)

        // Assert
        assertThat(sut.value).isGreaterThan(1)
    }

    @DisplayName("input이 2보다 작을 경우")
    @Test
    fun `sut throw IllegalArgumentException when input is less than 2`() {
        // Arrange
        val input = 1

        // Act, Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Number(input) }
    }
}

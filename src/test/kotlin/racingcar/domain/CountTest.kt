package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountTest {

    @DisplayName("횟수는  1 이상의 수 부터 들어올 수 있다")
    @Test
    fun `sut returns correctly`() {
        // Arrange
        val input = 1

        // Act
        val sut = Count(input)

        // Assert
        assertThat(sut.value).isGreaterThanOrEqualTo(1)
    }

    @DisplayName("입력한 횟수가 1보다 작을 경우")
    @Test
    fun `sut throw IllegalArgumentException when count is less than 1`() {
        // Arrange
        val input = 0

        // Act, Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Count(input) }
    }
}

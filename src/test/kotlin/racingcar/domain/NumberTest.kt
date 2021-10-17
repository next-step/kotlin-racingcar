package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
    @ParameterizedTest
    @ValueSource(ints = [1, 0, -1])
    fun `sut throw IllegalArgumentException when input is less than 2`(input: Int) {
        // Act, Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Number(input) }
    }
}

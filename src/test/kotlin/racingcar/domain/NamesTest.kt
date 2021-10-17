package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NamesTest {

    @DisplayName("자동차 경주는 2대 이상부터 시작할 수 있다.")
    @Test
    fun `sut returns correctly`() {
        // Arrange
        val input = listOf(
            Name("pobi"),
            Name("crong")
        )

        // Act
        val sut = Names(input)

        // Assert
        assertThat(sut.names.size).isGreaterThan(1)
    }

    @DisplayName("경주 준비 자동차가 2대보다 작을 경우")
    @Test
    fun `sut throw IllegalArgumentException when input is less than 2`() {
        // Arrange
        val input = listOf(Name("pobi"))

        // Act, Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Names(input) }
    }
}

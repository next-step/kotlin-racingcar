package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NameTest {

    @DisplayName("자동차의 이름을 입력할 수 있다")
    @Test
    fun `sut returns name`() {
        // Arrange
        val value = "tommy"

        // Act
        val sut = Name(value)

        // Assert
        assertThat(sut).isNotNull
        assertThat(sut.value).isEqualTo(value)
    }

    @DisplayName("자동차 이름의 길이가 5자를 초과할 경우")
    @Test
    fun `sut throw IllegalArgumentException when name length is greater than 5`() {
        // Arrange
        val value = "yellow"

        // Act, Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name(value) }
    }
}

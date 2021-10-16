package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Cars
import racingcar.domain.Number

class CarsTest {

    @DisplayName("input으로 입력되는 숫자만큼 n개의 Car를 생성한다")
    @Test
    fun `sut returns cars`() {
        // Arrange
        val number = Number(3)

        // Act
        val sut = Cars(number)

        // Assert
        assertThat(sut.cars).hasSize(3)
    }
}

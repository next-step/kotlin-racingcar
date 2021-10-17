package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Cars
import racingcar.domain.Name
import racingcar.domain.Names

class CarsTest {

    @DisplayName("input으로 입력되는 이름만큼 n개의 Car를 생성한다")
    @Test
    fun `sut returns cars`() {
        // Arrange
        val names = Names(
            listOf(
                Name("pobi"),
                Name("crong"),
                Name("honux"),
            )
        )

        // Act
        val sut = Cars.register(names)

        // Assert
        assertThat(sut.cars).hasSize(3)
    }
}

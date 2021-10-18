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

    @DisplayName("경주 우승자를 찾는다. 우승자는 한 명 이상일 수 있다")
    @Test
    fun `sut returns racing winners`() {
        // Arrange
        val names = Names(
            listOf(
                Name("pobi"),
                Name("crong"),
                Name("honux"),
            )
        )
        val sut = Cars.register(names)

        // Act
        sut.race()
        val racingWinners = sut.findRacingWinners()

        // Assert
        assertThat(racingWinners.size).isGreaterThan(1)
    }
}

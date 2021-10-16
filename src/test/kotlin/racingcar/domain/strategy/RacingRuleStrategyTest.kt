package racingcar.domain.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingRuleStrategyTest {

    @DisplayName("자동차 속도가 4 이상일 경우 전진할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `sut returns true when can drive`(carSpeed: Int) {
        // Arrange
        val sut = RacingRuleStrategy()

        // Act
        val result = sut.canDrive(carSpeed)

        // Assert
        assertThat(result).isTrue
    }

    @DisplayName("자동차 속도가 4 미만일 경우 전진할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = [3, 2, 1, 0])
    fun `sut returns false when can't drive`(carSpeed: Int) {
        // Arrange
        val sut = RacingRuleStrategy()

        // Act
        val result = sut.canDrive(carSpeed)

        // Assert
        assertThat(result).isFalse
    }
}

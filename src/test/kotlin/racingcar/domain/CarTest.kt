package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.strategy.RacingRuleStrategy

class CarTest {

    @DisplayName("자동차 전진할 경우 위치가 변경된다")
    @Test
    fun `sut returns true when can drive`() {
        // Arrange
        val ruleStrategy = RacingRuleStrategy()
        val sut = Car(ruleStrategy)
        val originalPosition = sut.position.value

        // Act
        sut.drive(4)

        // Assert
        assertThat(sut.position.value).isGreaterThan(originalPosition)
    }

    @DisplayName("자동차가 전진하지 못할 경우 위치가 변경되지 않는다")
    @Test
    fun `sut returns increase position when can drive`() {
        // Arrange
        val ruleStrategy = RacingRuleStrategy()
        val sut = Car(ruleStrategy)
        val originalPosition = sut.position

        // Act
        val droveCar = sut.drive(3)

        // Assert
        assertThat(droveCar.position.value).isEqualTo(originalPosition.value)
    }
}

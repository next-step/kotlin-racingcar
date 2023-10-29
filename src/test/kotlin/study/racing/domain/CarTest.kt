package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CarTest {

    @Test
    fun `차를 최초 생성시 거리 0으로 생성된다`() {
        // Given
        val newCar = Car()

        // When
        val actual = newCar.getCarDistance()

        // Then
        assertThat(actual).isEqualTo(0)
    }

    @ParameterizedTest
    @MethodSource("carMovingProvider")
    fun `이동여부에 따라 차량이 이동한다`(
        isMoving: Boolean,
        expectedDistance: Int
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(isMoving)
        val actual = Car(strategyDouble)

        // When
        actual.tryMoveTheCar()

        // Then
        assertThat(actual.getCarDistance()).isEqualTo(expectedDistance)
    }

    companion object {
        @JvmStatic
        fun carMovingProvider() = listOf(
            Arguments.of(true, 1),
            Arguments.of(false, 0),
        )
    }
}

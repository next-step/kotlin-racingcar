package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import study.racing.strategy.RandomMoveStrategyDouble2

class CarTest {

    @Test
    fun `차를 최초 생성 시, 차량이름과 이동거리 0을 가지고 생성된다`() {
        // Given
        val randomMoveStrategyDouble = RandomMoveStrategyDouble2(listOf(true))
        val carName = CarName("abcd")

        // When
        val actual = Car(randomMoveStrategyDouble, carName)

        // Then
        assertAll(
            {
                assertThat(actual.distance).usingRecursiveComparison()
                    .isEqualTo(Distance())
            },
            {
                assertThat(actual.carName).usingRecursiveComparison()
                    .isEqualTo(carName)
            }
        )
    }

    @ParameterizedTest
    @EmptySource
    fun `차를 최소 생성 시, 차량이름이 없으면 에러를 반환한다`(
        name: String
    ) {
        // Given
        val randomMoveStrategyDouble = RandomMoveStrategyDouble2(listOf(true))

        // When & Then
        assertThrows<IllegalArgumentException> {
            Car(randomMoveStrategyDouble, CarName(name))
        }
    }

    @ParameterizedTest
    @MethodSource("carMovingProvider")
    fun `이동여부에 따라 차량이 이동한다`(
        isMoving: Boolean,
        expectedDistance: Int
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble2(listOf(isMoving))
        val actual = Car(strategyDouble, CarName("abcd"))

        // When
        actual.tryMoveTheCar()

        // Then
        assertThat(actual.getCarDistance()).isEqualTo(expectedDistance)
    }

    @Test
    fun `자동차 객체를 복사하면 해쉬값이 다르고 값은 같은 객체가 생성된다`() {
        // Given
        val strategyDouble = RandomMoveStrategyDouble2(listOf(true))
        val originalCar = Car(strategyDouble, CarName("a"))

        // When
        val copyCar = originalCar.copy()

        // Then
        assertAll(
            { assertThat(originalCar).isNotEqualTo(copyCar) },
            {
                assertThat(originalCar).usingRecursiveComparison()
                    .isEqualTo(copyCar)
            }
        )
    }

    companion object {
        @JvmStatic
        fun carMovingProvider() = listOf(
            Arguments.of(true, 1),
            Arguments.of(false, 0),
        )
    }
}

package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import study.racing.strategy.RandomMoveStrategyDouble
import study.racing.strategy.SoloWinnerMoveStrategy

class CarTest {

    @Test
    fun `차를 최초 생성 시, 차량이름과 이동거리 0을 가지고 생성된다`() {
        // Given
        val randomMoveStrategyDouble = RandomMoveStrategyDouble(true)
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
        val randomMoveStrategyDouble = RandomMoveStrategyDouble(true)

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
        val strategyDouble = RandomMoveStrategyDouble(isMoving)
        val actual = Car(strategyDouble, CarName("abcd"))

        // When
        actual.tryMoveTheCar()

        // Then
        assertThat(actual.getCarDistance()).isEqualTo(expectedDistance)
    }

    @ParameterizedTest
    @MethodSource("carSoloMovingProvider")
    fun `차량순서값과 라운드순서값을 주입하면 이동여부에 따라 차량이 이동한다`(
        roundCount: Int,
        carCount: Int,
        shuffleCarIndex: List<Int>,
        carIndex: Int,
        roundIndex: Int,
    ) {
        // Given
        val strategy = SoloWinnerMoveStrategy(
            roundCount,
            carCount,
            shuffleCarIndex
        )
        val actual = Car(strategy, CarName("a"))

        // When
        actual.tryMoveTheCar(carIndex, roundIndex)

        // Then
        assertThat(actual.getCarDistance()).isEqualTo(1)
    }

    @ParameterizedTest
    @MethodSource("carSoloMovingErrorProvider")
    fun `유효하지 않은 차량순서값과 라운드순서값을 사용해서 이동을 지시하면 에러를 한다`(
        roundCount: Int,
        carCount: Int,
        shuffleCarIndex: List<Int>,
        carIndex: Int,
        roundIndex: Int,
    ) {
        // Given
        val strategy = SoloWinnerMoveStrategy(
            roundCount,
            carCount,
            shuffleCarIndex
        )
        val actual = Car(strategy, CarName("a"))

        // When & Then
        assertThrows<IllegalArgumentException> {
            actual.tryMoveTheCar(carIndex, roundIndex)
        }
    }

    @Test
    fun `자동차 객체를 복사하면 해쉬값이 다르고 값은 같은 객체가 생성된다`() {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(true)
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

        @JvmStatic
        fun carSoloMovingProvider() = listOf(
            Arguments.of(1, 2, listOf(0, 1), 0, 0),
            Arguments.of(2, 3, listOf(0, 1, 2), 0, 0),
        )

        @JvmStatic
        fun carSoloMovingErrorProvider() = listOf(
            Arguments.of(1, 2, listOf(0, 1), 3, 0),
            Arguments.of(1, 2, listOf(0, 1), 0, 3),
            Arguments.of(1, 2, listOf(0, 1), 3, 3),
        )
    }
}

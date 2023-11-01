package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import study.racing.strategy.RandomMoveStrategyDouble

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "a,b", "a,b,c", "ab,cd,e"])
    fun `입력된 자동차 이름들 만큼 차량이 생성된다`(
        carNamesString: String
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(listOf(true))
        val carNames = carNamesString.split(",")
            .map {
                CarName(it)
            }
        // When
        val actual = Cars.from(carNames)

        // Then
        val expectedCarCount = carNames.size

        assertAll(
            { assertThat(actual.getCarsMoveDistance().size).isEqualTo(expectedCarCount) },
            {
                assertThat(actual).usingRecursiveComparison()
                    .isEqualTo(Cars.of(carNames, strategyDouble))
            }
        )
    }

    @ParameterizedTest
    @EmptySource
    fun `차량 이름이 없으면 에러를 반환한다`(
        carNames: String
    ) {
        assertThrows<IllegalArgumentException> {
            Cars.from(listOf(CarName(carNames)))
        }
    }

    @ParameterizedTest
    @MethodSource("carsMovingProvider")
    fun `이동여부에 따라 차량들의 각각 이동을 할 수 있다`(
        carNamesString: String,
        isMoving: List<Boolean>,
        expectedDistance: List<Int>
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(isMoving)
        val carNames = carNamesString.split(",")
            .map {
                CarName(it)
            }
        val actual = Cars.of(carNames, strategyDouble)

        // When
        actual.moveTheCars()

        // Then
        assertThat(actual.getCarsMoveDistance()).isEqualTo(expectedDistance)
    }

    @ParameterizedTest
    @MethodSource("carsMaxMovingProvider")
    fun `가장 멀리 이동한 차들의 이름을 알 수 있다`(
        carNamesString: String,
        isMoving: List<Boolean>,
        winnerName: String
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(isMoving)
        val carNames = carNamesString.split(",")
            .map {
                CarName(it)
            }
        val cars = Cars.of(carNames, strategyDouble)
        cars.moveTheCars()

        // When
        val actual = cars.getRacingWinnerNames()

        // Then
        assertThat(actual.first()).isEqualTo(winnerName)
    }

    companion object {
        @JvmStatic
        fun carsMovingProvider() = listOf(
            Arguments.of("a,b,c,d", listOf(false, true, true, false), listOf(0, 1, 1, 0)),
            Arguments.of("a,b,c,d", listOf(true, true, true, false), listOf(1, 1, 1, 0)),
            Arguments.of("a,b,c", listOf(false, true, false), listOf(0, 1, 0)),
        )

        @JvmStatic
        fun carsMaxMovingProvider() = listOf(
            Arguments.of("a,b", listOf(false, true, false, true), "b"),
        )
    }
}

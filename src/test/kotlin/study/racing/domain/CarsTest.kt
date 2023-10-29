package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "a,b", "a,b,c", "ab,cd,e"])
    fun `입력된 자동차 이름들 만큼 차량이 생성된다`(
        carNames: String
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(true)

        // When
        val actual = Cars.from(carNames)

        // Then
        val expectedCarCount = carNames.split(",")
            .map {
                CarName(it)
            }.size

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
            Cars.from(carNames)
        }
    }

    @ParameterizedTest
    @MethodSource("carsMovingProvider")
    fun `이동여부에 따라 차량들의 각각 이동을 할 수 있다`(
        carNames: String,
        isMoving: Boolean,
        expectedDistance: Int
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(isMoving)
        val actual = Cars.of(carNames, strategyDouble)

        // When
        actual.moveTheCars()

        // Then
        val firstCar = actual.getCarsMoveDistance()
            .first()
        val lastCar = actual.getCarsMoveDistance()
            .last()

        assertAll(
            { assertThat(firstCar).isEqualTo(expectedDistance) },
            { assertThat(lastCar).isEqualTo(expectedDistance) },
        )
    }

    companion object {
        @JvmStatic
        fun carsMovingProvider() = listOf(
            Arguments.of("a,b,c,d", false, 0),
            Arguments.of("a,b,c,d", true, 1),
        )
    }
}

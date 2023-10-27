package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import study.racing.strategy.MoveStrategy

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 10, 100])
    fun `입력된 수만큼 차량이 생성된다`(
        count: Int
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(true)

        // When
        val actual = Cars.from(count)

        // Then
        val expected = createCarsExpected(count, strategyDouble)
        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(expected)
    }

    private fun createCarsExpected(
        count: Int,
        strategy: MoveStrategy
    ): Cars {
        val carList = mutableListOf<Car>()
        repeat(count) {
            carList.add(Car())
        }
        return Cars.of(count, strategy)
    }

    @Test
    fun `차량 생성 수가 0이하면 에러를 반환한다`() {
        // Given & When
        // Then
        assertThrows<IllegalArgumentException> {
            Cars.from(0)
        }
    }

    @ParameterizedTest
    @MethodSource("carsMovingProvider")
    fun `이동여부에 따라 차량들의 각각 이동을 할 수 있다`(
        carCount: Int,
        isMoving: Boolean,
        expectedDistance: Int
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(isMoving)
        val actual = Cars.of(carCount, strategyDouble)

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
            Arguments.of(2, false, 0),
            Arguments.of(2, true, 1),
        )
    }
}

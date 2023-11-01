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
import study.racing.strategy.SoloWinnerMoveStrategy

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "a,b", "a,b,c", "ab,cd,e"])
    fun `입력된 자동차 이름들 만큼 차량이 생성된다`(
        carNamesString: String
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(true)
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
        isMoving: Boolean,
        expectedDistance: Int
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
        val firstCar = actual.getCarsMoveDistance()
            .first()
        val lastCar = actual.getCarsMoveDistance()
            .last()

        assertAll(
            { assertThat(firstCar).isEqualTo(expectedDistance) },
            { assertThat(lastCar).isEqualTo(expectedDistance) },
        )
    }

    @ParameterizedTest
    @MethodSource("carsMaxMovingProvider")
    fun `가장 멀리 이동한 차들의 수, 이름을 알 수 있다`(
        carNamesString: String,
        expectedMaxMovingCarNames: List<String>,
        expectedMaxMovingDistance: Int
    ) {
        // Given
        val strategyDouble = RandomMoveStrategyDouble(true)
        val carNames = carNamesString.split(",")
            .map {
                CarName(it)
            }
        val actual = Cars.of(carNames, strategyDouble)
        makeWinner(actual, expectedMaxMovingCarNames, expectedMaxMovingDistance)

        // When
        val winner = actual.getRacingWinnerNames()

        // Then
        assertAll(
            {
                val expectWinnerCount = expectedMaxMovingCarNames.size
                assertThat(winner.size).isEqualTo(expectWinnerCount)
            },
            {
                assertThat(winner).isEqualTo(expectedMaxMovingCarNames)
            },
        )
    }

    @ParameterizedTest
    @MethodSource("carsSoloMovingProvider")
    fun `단독 우승 전략을 사용시 반드시 단독 우승자가 나온다`(
        roundCount: Int,
        carNames: List<CarName>,
        shuffleCarIndex: List<Int>,
        winnerNames: List<String>,
    ) {
        // Given
        val strategy = SoloWinnerMoveStrategy(
            roundCount,
            carNames.size,
            shuffleCarIndex
        )
        val actual = Cars.of(carNames, strategy)

        // When
        repeat(roundCount) {
            actual.moveTheCars(it)
        }

        // Then
        assertAll(
            { assertThat(actual.getRacingWinnerNames().size).isEqualTo(1) },
            { assertThat(actual.getRacingWinnerNames()).isEqualTo(winnerNames) },
        )
    }

    private fun makeWinner(
        candidateCars: Cars,
        winnerCarNames: List<String>,
        winnerDistance: Int
    ) {
        candidateCars.filter {
            winnerCarNames.contains(it.getCarName())
        }.forEach { car ->
            repeat(times = winnerDistance) {
                car.tryMoveTheCar()
            }
        }
    }

    companion object {
        @JvmStatic
        fun carsMovingProvider() = listOf(
            Arguments.of("a,b,c,d", false, 0),
            Arguments.of("a,b,c,d", true, 1),
        )

        @JvmStatic
        fun carsMaxMovingProvider() = listOf(
            Arguments.of("a,b,c,d", listOf("a"), 1),
            Arguments.of("a,b,c,d", listOf("a"), 10),
            Arguments.of("a,b,c,d", listOf("a", "b"), 2),
            Arguments.of("a,b,c,d", listOf("a", "b"), 10),
            Arguments.of("a,b,c,d", listOf("a", "b", "c"), 3),
            Arguments.of("a,b,c,d", listOf("a", "b", "c"), 10),
            Arguments.of("a,b,c,d", listOf("a", "b", "c", "d"), 4),
            Arguments.of("a,b,c,d", listOf("a", "b", "c", "d"), 10),
        )

        @JvmStatic
        fun carsSoloMovingProvider() = listOf(
            Arguments.of(
                2,
                listOf(CarName("a"), CarName("b"), CarName("c")),
                listOf(0, 1, 2),
                listOf("a")
            ),
            Arguments.of(
                3,
                listOf(CarName("a"), CarName("b"), CarName("c"), CarName("d")),
                listOf(0, 1, 2, 3),
                listOf("a")
            ),
            Arguments.of(
                2,
                listOf(CarName("a"), CarName("b"), CarName("c")),
                listOf(1, 0, 2),
                listOf("b")
            ),
            Arguments.of(
                3,
                listOf(CarName("a"), CarName("b"), CarName("c"), CarName("d")),
                listOf(3, 2, 1, 0),
                listOf("d")
            ),
        )
    }
}

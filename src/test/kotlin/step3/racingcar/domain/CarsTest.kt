package step3.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("Car 객체의 복수 형태의 객체인 Cars 테스트")
internal class CarsTest {
    @DisplayName("주어진 Position, NumberOfCar 파라미터 값이 올바른 경우 Cars 생성 성공")
    @ParameterizedTest
    @MethodSource("correctPositionsAndNumberOfCars")
    fun given_CorrectPositionAndNumberOfCars_when_CreateCars_then_Success(
        givenPosition: Int,
        givenNumberOfCars: Int
    ) {
        // Arrange
        // Act
        val racingCars = Cars(
            startPosition = Position(givenPosition),
            numberOfCars = NumberOfCars(givenNumberOfCars)
        )

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(givenNumberOfCars)
    }

    @DisplayName("주어진 CustomEngine, Position, NumberOfCar 객체가 올바른 경우 Cars 생성 성공")
    @ParameterizedTest
    @MethodSource("correctCustomEngineAndPositionsAndNumberOfCars")
    fun given_CorrectCustomEngineAndCorrectPositionAndNumberOfCars_when_CreateCars_then_Success(
        engine: Engine,
        startPosition: Position,
        numberOfCars: NumberOfCars
    ) {
        // Arrange
        // Act
        val racingCars = Cars(
            engine = engine,
            startPosition = startPosition,
            numberOfCars = numberOfCars
        )

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(numberOfCars.value)

        val currentPositions = racingCars.carsCurrentPosition
        currentPositions.forEach { distance ->
            assertThat(distance).isEqualTo(startPosition.value)
        }
    }

    @DisplayName("NumberOfCars 객체가 올바르게 생성된 경우 모든 차들이 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("correctCustomEngineAndPositionsAndNumberOfCars")
    fun given_CorrectCustomEngineAndCorrectPosition_when_CreateCars_then_MoveOneStep(
        engine: Engine,
        startPosition: Position,
        numberOfCars: NumberOfCars
    ) {
        // Arrange
        val racingCars = Cars(
            engine = engine,
            startPosition = startPosition,
            numberOfCars = numberOfCars
        )

        // Act
        racingCars.race()

        // Assert
        val currentPositions = racingCars.carsCurrentPosition
        currentPositions.forEach { distance ->
            assertThat(distance).isEqualTo(startPosition.value + MOVE_ONE_STEP)
        }
    }

    companion object {
        private const val START_POSITION = 0
        private const val MOVE_ONE_STEP = 1
        private const val NUMBER_OF_CARS = 10

        @JvmStatic
        fun correctPositionsAndNumberOfCars(): Stream<Arguments> = Stream.of(
            Arguments.of(0, 1),
            Arguments.of(1, 100),
            Arguments.of(2, 100_000),
            Arguments.of(100, 18_292),
            Arguments.of(100_000, 291_11),
            Arguments.of(1_000_000_000, 192_111),
            Arguments.of(28_792_181, 1_000_000),
        )

        @JvmStatic
        fun correctCustomEngineAndPositionsAndNumberOfCars(): Stream<Arguments> =
            Stream.of(
                Arguments.of(CustomEngine(4), Position(START_POSITION), NumberOfCars(NUMBER_OF_CARS)),
                Arguments.of(CustomEngine(5), Position(START_POSITION), NumberOfCars(NUMBER_OF_CARS)),
                Arguments.of(CustomEngine(6), Position(START_POSITION), NumberOfCars(NUMBER_OF_CARS)),
                Arguments.of(CustomEngine(7), Position(START_POSITION), NumberOfCars(NUMBER_OF_CARS)),
                Arguments.of(CustomEngine(8), Position(START_POSITION), NumberOfCars(NUMBER_OF_CARS)),
                Arguments.of(CustomEngine(9), Position(START_POSITION), NumberOfCars(NUMBER_OF_CARS)),
            )
    }
}

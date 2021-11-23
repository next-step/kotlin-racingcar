package racingcar.domain.cars

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("`Car` 객체의 복수 형태 객체인 Cars 테스트")
internal class CarsTest {
    @DisplayName("아무것도 주어지지 않으면 기본 값 `Cars` 생성 성공")
    @Test
    fun createDefaultCarsIsSuccessIfGivenNothing() {
        // Arrange
        // Act
        val cars = Cars()

        // Assert
        assertThat(cars.numberOfExistCars).isEqualTo(1)
        assertThat(cars.currentRacingLabs.size).isEqualTo(1)
        assertThat(cars.currentRacingLabs[0]).isEqualTo(0)
    }

    @DisplayName("생성할 차의 수가 주어지면 `courseInRacingCars` 함수를 통해 `Car` List 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = [1, 28, 300, 73_065, 200_000])
    fun createCarListIsSuccessIfGivenNumberOfRacingCars(numberOfRacingCars: Int) {
        // Arrange
        val cars = Cars()

        // Act
        val racingCars = cars.courseInRacingCars(numberOfRacingCars)

        // Assert
        assertThat(racingCars.size).isEqualTo(numberOfRacingCars)
    }

    @DisplayName("`Engine`, `RacingDistance`, `NumberOfRacingCars`이 주어지면 Cars 생성 성공")
    @ParameterizedTest
    @MethodSource("defaultEnginesAndStartingPointAndNumberOfCars")
    fun createCarsIsSuccessIfGivenEngineAndStartingPointAndNumberOfRacingCars(
        defaultRacing: Racing,
        startingPoint: Int,
        numberOfRacingCars: Int
    ) {
        // Arrange
        // Act
        val racingCars = Cars(
            racing = defaultRacing,
            racingDistance = RacingDistance(value = startingPoint),
            numberOfRacingCars = NumberOfRacingCars(numberOfRacingCars)
        )

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(numberOfRacingCars)
        racingCars.currentRacingLabs.forEach { distance ->
            assertThat(distance).isEqualTo(startingPoint)
        }
    }

    @DisplayName("`CustomEngine`, `RacingDistance`, `NumberOfRacingCars`이 주어지면 모든 차들이 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("customEnginesAndRacingDistancesAndNumberOfRacingCars")
    fun carsRaceAreSuccessIfGivenCustomEngineAndRacingDistanceAndNumberOfRacingCars(
        customEngine: Engine,
        customRacing: Racing,
        startRacingDistance: RacingDistance,
        numberOfRacingCars: NumberOfRacingCars
    ) {
        // Arrange
        val racingCars = Cars(
            racing = customRacing,
            racingDistance = startRacingDistance,
            numberOfRacingCars = numberOfRacingCars
        )

        // Act
        racingCars.races(customEngine)

        // Assert
        val currentRacingLabs = racingCars.currentRacingLabs
        currentRacingLabs.forEach { distance ->
            assertThat(distance).isEqualTo(startRacingDistance.value + MOVE_ONE_STEP)
        }
    }

    companion object {
        private const val MOVE_ONE_STEP = 1
        private const val NUMBER_OF_CARS = 10
        private val defaultRacing = Racing()
        private val racingDistance = RacingDistance()
        private val numberOfRacingCars = NumberOfRacingCars(NUMBER_OF_CARS)

        @JvmStatic
        fun defaultEnginesAndStartingPointAndNumberOfCars(): Stream<Arguments> = Stream.of(
            Arguments.of(defaultRacing, 0, 1),
            Arguments.of(defaultRacing, 1, 100),
            Arguments.of(defaultRacing, 2, 100_000),
            Arguments.of(defaultRacing, 100, 18_292),
            Arguments.of(defaultRacing, 100_000, 291_11),
            Arguments.of(defaultRacing, 1_000_000_000, 192_111),
            Arguments.of(defaultRacing, 28_792_181, 1_000_000),
        )

        // engine = Engine::defaultCylinder
        @JvmStatic
        fun customEnginesAndRacingDistancesAndNumberOfRacingCars(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    CustomEngine(4),
                    Racing(),
                    racingDistance,
                    numberOfRacingCars
                ),
                Arguments.of(
                    CustomEngine(5),
                    Racing(),
                    racingDistance,
                    numberOfRacingCars
                ),
                Arguments.of(
                    CustomEngine(6),
                    Racing(),
                    racingDistance,
                    numberOfRacingCars
                ),
                Arguments.of(
                    CustomEngine(7),
                    Racing(),
                    racingDistance,
                    numberOfRacingCars
                ),
                Arguments.of(
                    CustomEngine(8),
                    Racing(),
                    racingDistance,
                    numberOfRacingCars
                ),
                Arguments.of(
                    CustomEngine(9),
                    Racing(),
                    racingDistance,
                    numberOfRacingCars
                )
            )
    }
}

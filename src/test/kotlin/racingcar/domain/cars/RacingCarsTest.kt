package racingcar.domain.cars

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("`RacingCar` 객체의 복수 형태 객체인 `RacingCars` 테스트")
internal class RacingCarsTest {
    @DisplayName("차 이름이 한 개 주어지면 `RacingCars` 생성 시 차를 한개만 가지고 있는 `Cars` 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = ["그랜저", "소나타", "아반떼", "K5"])
    fun createRacingCarsIsSuccessIfGivenACarName(carName: String) {
        // Arrange
        // Act
        val racingCars = RacingCars(carsNames = listOf(carName))

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(1)
        assertThat(racingCars.currentRacingLabs.size).isEqualTo(1)
        assertThat(racingCars.currentRacingLabs[0]).isEqualTo(0)
    }

    @DisplayName("`CarsNames`이 주어지면 `RacingCars` 생성 성공")
    @ParameterizedTest
    @MethodSource("carsNames")
    fun createRacingCarsIsSuccessIfGivenCarsNames(
        carsNames: List<String>
    ) {
        // Arrange
        // Act
        val racingCars = RacingCars(carsNames = carsNames)

        val numberOfRacingCars = carsNames.size

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(numberOfRacingCars)
        racingCars.currentRacingLabs.forEach { distance ->
            assertThat(distance).isEqualTo(0)
        }
    }

    @DisplayName("`CarsNames`, `Racing`, `StartingPoint`가 주어지면 `RacingCars` 생성 성공")
    @ParameterizedTest
    @MethodSource("carsNamesAndStartingPointAndNumberOfCars")
    fun createRacingCarsIsSuccessIfGivenCarsNamesAndRacingAndStartingPoint(
        carsNames: List<String>,
        defaultRacing: Racing,
        startingPoint: Int
    ) {
        // Arrange
        // Act
        val racingCars = RacingCars(
            carsNames = carsNames,
            racing = defaultRacing,
            racingDistance = RacingDistance(value = startingPoint)
        )

        val numberOfRacingCars = carsNames.size

        // Assert
        assertThat(racingCars.numberOfExistCars).isEqualTo(numberOfRacingCars)
        racingCars.currentRacingLabs.forEach { distance ->
            assertThat(distance).isEqualTo(startingPoint)
        }
    }

    @DisplayName("`RacingCars` 객체가 올바르게 생성되고 `CustomEngine`이 주어지면 모든 차들이 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("customEnginesAndRacingDistances")
    fun carsRaceAreSuccessIfGivenCustomEngineAndRacingDistance(
        customEngine: Engine,
        startRacingDistance: RacingDistance
    ) {
        // Arrange
        val racingCars = RacingCars(
            carsNames = listOf("소나타", "아반떼", "그랜저", "제네시스"),
            racing = Racing(),
            racingDistance = startRacingDistance
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
        private val carsNames = listOf("소나타", "아반떼", "그랜저", "제네시스")
        private val defaultRacing = Racing()

        @JvmStatic
        fun carsNames(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("소나타", "아반떼", "그랜저", "제네시스")),
            Arguments.of(listOf("아우디 A6", "벤츠 E Class", "BMW 4")),
            Arguments.of(listOf("K3", "K5", "K7", "K8", "K9")),
            Arguments.of(listOf("미니쿠퍼", "렉서스 RX"))
        )

        @JvmStatic
        fun carsNamesAndStartingPointAndNumberOfCars(): Stream<Arguments> = Stream.of(
            Arguments.of(carsNames, defaultRacing, 0),
            Arguments.of(carsNames, defaultRacing, 1),
            Arguments.of(carsNames, defaultRacing, 2),
            Arguments.of(carsNames, defaultRacing, 100),
            Arguments.of(carsNames, defaultRacing, 100_000),
            Arguments.of(carsNames, defaultRacing, 1_000_000_000),
            Arguments.of(carsNames, defaultRacing, 28_792_181),
        )

        @JvmStatic
        fun customEnginesAndRacingDistances(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    CustomEngine(4),
                    RacingDistance(100)
                ),
                Arguments.of(
                    CustomEngine(5),
                    RacingDistance(100_000)
                ),
                Arguments.of(
                    CustomEngine(6),
                    RacingDistance(81_287_478)
                ),
                Arguments.of(
                    CustomEngine(7),
                    RacingDistance(181_938_115)
                ),
                Arguments.of(
                    CustomEngine(8),
                    RacingDistance(128_115)
                ),
                Arguments.of(
                    CustomEngine(9),
                    RacingDistance(2_115)
                )
            )
    }
}

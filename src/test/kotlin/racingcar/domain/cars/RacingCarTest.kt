package racingcar.domain.cars

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("자동차 객체인 `RacingCar` 테스트")
internal class RacingCarTest {
    @DisplayName("아무것도 주어지지 않으면 `RacingCar` 생성 시 성공")
    @Test
    fun createRacingCarIsSuccessIfGivenNothing() {
        // Arrange
        // Act
        val racingCar = RacingCar()

        // Assert
        assertThat(racingCar.name).isEqualTo("Anonymous")
    }

    @DisplayName("차 이름이 주어지면 해당 이름을 가진 `RacingCar` 생성 시 성공")
    @ParameterizedTest
    @ValueSource(strings = ["소나타", "아반떼", "그랜저", "제네시스"])
    fun createRacingCarIsSuccessIfGivenCorrectCarName(givenCarName: String) {
        // Arrange
        // Act
        val racingCar = RacingCar(name = givenCarName)

        // Assert
        assertThat(racingCar.name).isEqualTo(givenCarName)
    }

    @DisplayName("경주차 이름이 공백 또는 빈 값이 주어지면 `RacingCar` 생성 시 실패")
    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "               "])
    fun createRacingCarIsFailIfGivenIncorrectCarName(givenCarName: String) {
        // Arrange
        // Act
        Assertions.assertThatThrownBy() {
            val racingCar = RacingCar(name = givenCarName)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("전진 가능한 엔진이 주어지면 경주차가 한 칸 전진 시 성공")
    @Test
    fun racingCarMoveOneStepIsSuccessToIfGivenCustomEngineWhatCanRace() {
        // Arrange
        val racingCar = RacingCar(name = "소나타")

        // Act
        racingCar.race(CustomEngine(NUMBER_OF_RACEABLE_CYLINDER))
        val nextRacingDistance = racingCar.racingDistance()

        // Assert
        assertThat(nextRacingDistance).isEqualTo(MOVE_ONE_STEP_FORWARD)
    }

    @DisplayName("전진 가능한 엔진과 주행 거리가 주어지면 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("customEnginesWhatCanRaceAndCorrectRacingDistances")
    fun raceOneStepIsSuccessIfGivenCustomEngineWhatCanRaceAndRacingDistance(
        engine: Engine,
        racingDistance: RacingDistance
    ) {
        // Arrange
        val racingCar = RacingCar(name = "소나타", racingDistance = racingDistance)

        // Act
        racingCar.race(engine = engine)
        val nextRacingDistance = racingCar.racingDistance()

        // Assert
        assertThat(nextRacingDistance).isEqualTo(racingDistance.value + MOVE_ONE_STEP_FORWARD)
    }

    @DisplayName("전진 불가능한 엔진과 주행 거리가 주어지면 한 칸 전진 시 제자리 유지")
    @ParameterizedTest
    @MethodSource("customEnginesWhatCanNotRaceAndCorrectRacingDistances")
    fun raceStopIfGivenCustomEngineWhatCanNotRaceAndRacingDistance(
        engine: Engine,
        racingDistance: RacingDistance
    ) {
        // Arrange
        val racingCar = RacingCar(name = "소나타", racingDistance = racingDistance)

        // Act
        racingCar.race(engine = engine)
        val nextRacingDistance = racingCar.racingDistance()

        // Assert
        assertThat(nextRacingDistance).isEqualTo(racingDistance.value + STOP)
    }

    @DisplayName("`RacingCar` 복제하면 동일한 이름과 주행거리를 가진 `RacingCar` 생성 성공")
    @ParameterizedTest
    @MethodSource("racingCars")
    fun racingCarCopyIsSuccessIfGivenRacingCarList(racingCar: RacingCar) {
        // Arrange
        val originName = racingCar.name
        val originRacingDistance = racingCar.racingDistance()

        // Act
        val copyRacingCar = racingCar.copyRacingCar()

        // Assert
        assertThat(copyRacingCar.name).isEqualTo(originName)
        assertThat(copyRacingCar.racingDistance()).isEqualTo(originRacingDistance)
    }

    companion object {
        private const val NUMBER_OF_RACEABLE_CYLINDER = 4
        private const val MOVE_ONE_STEP_FORWARD = 1
        private const val STOP = 0

        @JvmStatic
        fun customEnginesWhatCanRaceAndCorrectRacingDistances(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    CustomEngine(4),
                    RacingDistance(value = 0)
                ),
                Arguments.of(
                    CustomEngine(5),
                    RacingDistance(value = 100_200)
                ),
                Arguments.of(
                    CustomEngine(6),
                    RacingDistance(value = 871)
                ),
                Arguments.of(
                    CustomEngine(7),
                    RacingDistance(value = 108_186_191)
                ),
                Arguments.of(
                    CustomEngine(8),
                    RacingDistance(value = 1_738_195_664)
                )
            )

        @JvmStatic
        fun customEnginesWhatCanNotRaceAndCorrectRacingDistances(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    CustomEngine(0),
                    RacingDistance(value = 0)
                ),
                Arguments.of(
                    CustomEngine(1),
                    RacingDistance(value = 108_783)
                ),
                Arguments.of(
                    CustomEngine(2),
                    RacingDistance(value = 593_286_565)
                ),
                Arguments.of(
                    CustomEngine(3),
                    RacingDistance(value = 100_000_000)
                )
            )

        @JvmStatic
        fun racingCars(): Stream<Arguments> =
            Stream.of(
                Arguments.of(RacingCar()),
                Arguments.of(RacingCar(name = "소나타", RacingDistance(100))),
                Arguments.of(RacingCar(name = "그랜저", RacingDistance(380_472_771))),
                Arguments.of(RacingCar(name = "제네시스", RacingDistance(1_000_000_000)))
            )
    }
}

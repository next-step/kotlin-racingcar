package racingcar.domain.racing

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import java.util.stream.Stream

@DisplayName("주행 거리(현재 위치)를 표현하는 객체인 `RacingDistance` 테스트")
internal class RacingDistanceTest {
    @DisplayName("0 이상의 값이 주어지면 `RacingDistance` 객체 생성 시 성공")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 100, 3_824, 58_102, 1_000_000, 2_000_000_000])
    fun createRacingDistanceIsSuccessIfGivenNumberIsPositiveValue(startingPoint: Int) {
        // Arrange
        // Act
        val racingDistance = RacingDistance(value = startingPoint)

        // Assert
        assertThat(racingDistance.value).isEqualTo(startingPoint)
    }

    @DisplayName("음수의 값이 주어지면 `RacingDistance` 객체 생성 시 실패")
    @ParameterizedTest
    @MethodSource("negativeValues")
    fun createRacingDistanceIsFailIfGivenNumberIsNegativeValue(
        negativeIntValue: Int,
        expectedException: Exception,
        containErrorMessages: String
    ) {
        // Arrange
        // Act
        // Assert
        Assertions.assertThatThrownBy() {
            RacingDistance(value = negativeIntValue)
        }.isInstanceOf(expectedException::class.java)
            .hasMessageContaining(containErrorMessages)
    }

    @DisplayName("전진 가능한 엔진이 주어지면 전진 가능 상태 반환")
    @ParameterizedTest
    @MethodSource("customEngineWhatCylinderIsGreaterThanThree")
    fun returnIsEnableRaceIfGivenCustomEngineWhatCanRace(
        engine: Engine
    ) {
        // Arrange
        val racingDistance = RacingDistance(value = 0)

        // Act
        val isEnableRace = racingDistance.isEnableRace(engine)

        // Assert
        assertThat(isEnableRace).isTrue
    }

    @DisplayName("전진 불가능한 엔진이 주어지면 전진 불가능 상태 반환")
    @ParameterizedTest
    @MethodSource("customEngineWhatCanRace")
    fun returnIsUnableRaceIfGivenCustomEngineWhatCanNotRace(
        engine: Engine
    ) {
        // Arrange
        val racingDistance = RacingDistance(value = 0)

        // Act
        val isEnableRace = racingDistance.isEnableRace(engine)

        // Assert
        assertThat(isEnableRace).isFalse
    }

    @DisplayName("전진 가능한 엔진이 주어지면 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("startingPointsAndExpectedDistanceAndCustomEngineWhatCanRace")
    fun raceOneStepIsSuccessIfGivenCustomEngineWhatCanRace(
        startingPoint: Int,
        expectedDistance: Int,
        engine: Engine
    ) {
        // Arrange
        val racingDistance = RacingDistance(value = startingPoint)

        // Act
        val distanceAfterRace = racingDistance.race(engine)

        // Assert
        assertThat(distanceAfterRace.value).isEqualTo(expectedDistance)
    }

    @DisplayName("전진 불가능한 엔진이 주어지면 한 칸 전진 시 제자리 유지")
    @ParameterizedTest
    @MethodSource("startingPointsAndCustomEngineWhatCanNotRace")
    fun raceStopIfGivenCustomEngineWhatCanNotRace(
        startingPoint: Int,
        expectedDistance: Int,
        engine: Engine
    ) {
        // Arrange
        val racingDistance = RacingDistance(value = startingPoint)

        // Act
        val distanceAfterRace = racingDistance.race(engine)

        // Assert
        assertThat(distanceAfterRace.value).isEqualTo(startingPoint)
    }

    companion object {
        private const val illegalArgumentErrorMessage = "Failed requirement"
        private val illegalArgumentException = IllegalArgumentException()

        @JvmStatic
        fun negativeValues(): Stream<Arguments> =
            Stream.of(
                Arguments.of(-1, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-231, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-191_297, illegalArgumentException, illegalArgumentErrorMessage),
                Arguments.of(-920_191_089, illegalArgumentException, illegalArgumentErrorMessage)
            )

        @JvmStatic
        fun customEngineWhatCylinderIsGreaterThanThree(): Stream<Arguments> =
            Stream.of(
                Arguments.of(CustomEngine(4)),
                Arguments.of(CustomEngine(5)),
                Arguments.of(CustomEngine(6)),
                Arguments.of(CustomEngine(7)),
                Arguments.of(CustomEngine(8)),
                Arguments.of(CustomEngine(9))
            )

        @JvmStatic
        fun customEngineWhatCanRace(): Stream<Arguments> =
            Stream.of(
                Arguments.of(CustomEngine(0)),
                Arguments.of(CustomEngine(1)),
                Arguments.of(CustomEngine(2)),
                Arguments.of(CustomEngine(3))
            )

        @JvmStatic
        fun startingPointsAndExpectedDistanceAndCustomEngineWhatCanRace(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, 1, CustomEngine(4)),
                Arguments.of(100, 101, CustomEngine(5)),
                Arguments.of(191_297, 191_298, CustomEngine(6)),
                Arguments.of(920_191_089, 920_191_090, CustomEngine(7)),
                Arguments.of(356_182, 356_183, CustomEngine(8)),
                Arguments.of(1_000_000_000, 1_000_000_001, CustomEngine(9))
            )

        @JvmStatic
        fun startingPointsAndCustomEngineWhatCanNotRace(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, 0, CustomEngine(0)),
                Arguments.of(192_888_731, 192_888_731, CustomEngine(1)),
                Arguments.of(65_287, 65_287, CustomEngine(2)),
                Arguments.of(1_663_100_951, 1_663_100_951, CustomEngine(3)),
            )
    }
}

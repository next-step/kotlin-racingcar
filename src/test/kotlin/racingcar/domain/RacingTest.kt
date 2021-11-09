package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.cars.RacingLab
import racingcar.domain.cars.Racing
import racingcar.domain.engine.CustomEngine
import java.util.stream.Stream

@DisplayName("경주를 위해 자동차의 전진과 정지를 담당하는 객체인 Racing 테스트")
internal class RacingTest {
    @DisplayName("3보다 큰 값으로 생성된 CustomEngine 객체가 주어진 경우 한 칸 전진")
    @ParameterizedTest
    @MethodSource("intValuesGreaterThanThree")
    fun given_CustomEngineAndIntValueGreaterThanThree_when_Race_then_Move(
        startPositionValue: Int,
        raceCriteria: Int
    ) {
        // Arrange
        val startRacingLab = RacingLab(startPositionValue)
        val engine = CustomEngine(raceCriteria)
        val racing = Racing(engine)

        // Act
        val nextPosition = racing.race(startRacingLab)

        // Assert
        assertThat(nextPosition.value).isEqualTo(startPositionValue + MOVE_ONE_STEP_FORWARD)
    }

    @DisplayName("4보다 작은 값으로 생성된 CustomEngine 객체가 주어진 경우 전진하지 않고 정지")
    @ParameterizedTest
    @MethodSource("intValuesLessThanFour")
    fun given_CustomEngineAndIntValueLessThanFour_when_Race_then_Stop(
        startPositionValue: Int,
        raceCriteria: Int
    ) {
        // Arrange
        val startRacingLab = RacingLab(startPositionValue)
        val engine = CustomEngine(raceCriteria)
        val racing = Racing(engine)

        // Act
        val nextPosition = racing.race(startRacingLab)

        // Assert
        assertThat(nextPosition.value).isEqualTo(startPositionValue + STOP)
    }

    companion object {
        private const val STOP = 0
        private const val MOVE_ONE_STEP_FORWARD = 1

        @JvmStatic
        fun intValuesGreaterThanThree(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, 4),
                Arguments.of(1, 5),
                Arguments.of(100, 6),
                Arguments.of(200_000, 7),
                Arguments.of(193_174_789, 8),
                Arguments.of(1_000_000_000, 9)
            )

        @JvmStatic
        fun intValuesLessThanFour(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(100, 3),
            )
    }
}

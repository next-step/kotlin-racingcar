package racingcar.domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.engine.CustomEngine
import java.util.stream.Stream

@DisplayName("경주를 위해 자동차의 전진과 정지를 담당하는 객체인 `Racing` 테스트")
internal class RacingTest {
    @DisplayName("실린더가 3보다 큰 값으로 생성된 `CustomEngine`이 주어지면 한 칸 전진")
    @ParameterizedTest
    @MethodSource("intValuesGreaterThanThree")
    fun moveOneStepIsSuccessIfGivenCustomEngineWhatCylinderIsGreaterThanThree(
        startingPoint: Int,
        cylinder: Int
    ) {
        // Arrange
        val racingDistance = RacingDistance(value = startingPoint)
        val racing = Racing()

        // Act
        val moveOneStep = racing.race(racingDistance = racingDistance, engine = CustomEngine(cylinder))

        // Assert
        assertThat(moveOneStep.value).isEqualTo(startingPoint + MOVE_ONE_STEP_FORWARD)
    }

    @DisplayName("실린더가 4보다 작은 값으로 생성된 `CustomEngine`이 주어지면 전진하지 않고 정지")
    @ParameterizedTest
    @MethodSource("intValuesLessThanFour")
    fun moveOneStepIsFailIfGivenCustomEngineWhatCylinderIsSmallerThanFour(
        startingPoint: Int,
        cylinder: Int
    ) {
        // Arrange
        val racingDistance = RacingDistance(value = startingPoint)
        val racing = Racing()

        // Act
        val stop = racing.race(racingDistance = racingDistance, engine = CustomEngine(cylinder))

        // Assert
        assertThat(stop.value).isEqualTo(startingPoint + STOP)
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

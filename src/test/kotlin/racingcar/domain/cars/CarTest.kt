package racingcar.domain.cars

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("자동차 객체인 Car 테스트")
internal class CarTest {
    @DisplayName("`CustomEngine`이 주어지면 경주차가 한 칸 전진 시 성공")
    @Test
    fun carIsSuccessToMoveOneStepIfGivenNothing() {
        // Arrange
        val racingCar = Car(racing = Racing(engine = CustomEngine(NUMBER_OF_MOVABLE_CYLINDER)))

        // Act
        racingCar.race()
        val nextRacingDistance = racingCar.racingDistance()

        // Assert
        assertThat(nextRacingDistance).isEqualTo(MOVE_ONE_STEP_FORWARD)
    }

    @DisplayName("`RacingDistance`와 `CustomEngine`이 주어지면 한 칸 전진 시 성공")
    @ParameterizedTest
    @MethodSource("correctRacingDistancesAndCustomEngines")
    fun carIsSuccessToMoveOneStepIfRacingDistanceAndCustomEngine(
        engine: Engine,
        racingDistance: RacingDistance
    ) {
        // Arrange
        val racingCar = Car(racing = Racing(engine = engine), racingDistance = racingDistance)

        // Act
        racingCar.race()
        val nextRacingDistance = racingCar.racingDistance()

        // Assert
        assertThat(nextRacingDistance).isEqualTo(racingDistance.value + MOVE_ONE_STEP_FORWARD)
    }

    companion object {
        private const val NUMBER_OF_MOVABLE_CYLINDER = 4
        private const val MOVE_ONE_STEP_FORWARD = 1

        @JvmStatic
        fun correctRacingDistancesAndCustomEngines(): Stream<Arguments> =
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
    }
}

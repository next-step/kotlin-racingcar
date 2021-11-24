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
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance
import java.util.stream.Stream

@DisplayName("자동차 객체인 Car 테스트")
internal class CarTest {
    @DisplayName("경주차 이름이 주어지면 Car 생성 시 성공")
    @ParameterizedTest
    @ValueSource(strings = ["소나타", "아반떼", "그랜저", "제네시스"])
    fun createCarIsSuccessIfGivenCorrectCarName(givenCarName: String) {
        // Arrange
        // Act
        val racingCar = Car(name = givenCarName)

        // Assert
        assertThat(racingCar.name).isEqualTo(givenCarName)
    }

    @DisplayName("경주차 이름이 공백 또는 빈 값이 주어지면 Car 생성 시 실패")
    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "               "])
    fun createCarIsFailIfGivenIncorrectCarName(givenCarName: String) {
        // Arrange
        // Act
        Assertions.assertThatThrownBy() {
            val racingCar = Car(name = givenCarName)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("`CustomEngine`이 주어지면 경주차가 한 칸 전진 시 성공")
    @Test
    fun carIsSuccessToMoveOneStepIfGivenNothing() {
        // Arrange
        val racingCar = Car(name = "소나타", racing = Racing())

        // Act
        racingCar.race(CustomEngine(NUMBER_OF_MOVABLE_CYLINDER))
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
        val racingCar = Car(name = "소나타", racing = Racing(), racingDistance = racingDistance)

        // Act
        racingCar.race(engine = engine)
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

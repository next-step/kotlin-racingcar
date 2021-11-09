package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.cars.Car
import racingcar.domain.engine.CustomEngine
import racingcar.domain.engine.Engine
import racingcar.domain.cars.RacingLab
import java.util.stream.Stream

@DisplayName("RacingLab, Engine을 생성자 파라미터로 받는 자동차 객체인 Car 테스트")
class CarTest {
    @DisplayName("주어진 CustomEngine가 올바른 경우 한 칸 전진")
    @ParameterizedTest
    @MethodSource("valuesForRace")
    fun given_CustomEngine_when_Race_then_MoveOneStep(
        start: RacingLab,
        engine: Engine,
        destination: RacingLab
    ) {
        // Arrange
        val racingCar = Car(start, engine)

        // Act
        racingCar.race()
        val currentPosition = racingCar.racingLab()

        // Assert
        assertThat(currentPosition).isEqualTo(destination.value)
    }

    @DisplayName("주어진 CustomEngine과 레이스 횟수가 올바른 경우 레이스 횟수 만큼 전진")
    @ParameterizedTest
    @MethodSource("valuesForNumberOfRaces")
    fun given_CustomEngineAndNumberOfRace_when_Race_then_MoveNumberOfRaceStep(
        start: RacingLab,
        engine: Engine,
        numberOfRace: Int,
        destination: RacingLab
    ) {
        // Arrange
        val racingCar = Car(start, engine)

        // Act
        racingCar.race(numberOfRace)
        val currentPosition = racingCar.racingLab()

        // Assert
        assertThat(currentPosition).isEqualTo(destination.value)
    }

    companion object {
        @JvmStatic
        fun valuesForRace(): Stream<Arguments> =
            Stream.of(
                Arguments.of(RacingLab(0), CustomEngine(4), RacingLab(1)),
                Arguments.of(RacingLab(100_200), CustomEngine(5), RacingLab(100_201)),
                Arguments.of(RacingLab(871), CustomEngine(6), RacingLab(872)),
                Arguments.of(RacingLab(108_186_191), CustomEngine(7), RacingLab(108_186_192)),
                Arguments.of(RacingLab(1_738_195_664), CustomEngine(8), RacingLab(1_738_195_665)),
            )

        @JvmStatic
        fun valuesForNumberOfRaces(): Stream<Arguments> =
            Stream.of(
                Arguments.of(RacingLab(0), CustomEngine(4), 10, RacingLab(10)),
                Arguments.of(RacingLab(100_200), CustomEngine(5), 10, RacingLab(100_210)),
                Arguments.of(RacingLab(871), CustomEngine(6), 50, RacingLab(921)),
                Arguments.of(RacingLab(108_186_191), CustomEngine(7), 100, RacingLab(108_186_291)),
                Arguments.of(RacingLab(1_738_195_664), CustomEngine(8), 10, RacingLab(1_738_195_674)),
                Arguments.of(RacingLab(0), CustomEngine(9), 1_000, RacingLab(1_000))
            )
    }
}

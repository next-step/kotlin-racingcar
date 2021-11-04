package step3.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import step3.racingcar.domain.cars.Car
import step3.racingcar.domain.engine.CustomEngine
import step3.racingcar.domain.engine.Engine
import step3.racingcar.domain.cars.Position
import java.util.stream.Stream

@DisplayName("Position, Engine을 생성자 파라미터로 받는 자동차 객체인 Car 테스트")
class CarTest {
    @DisplayName("주어진 CustomEngine가 올바른 경우 한 칸 전진")
    @ParameterizedTest
    @MethodSource("valuesForRace")
    fun given_CustomEngine_when_Race_then_MoveOneStep(
        start: Position,
        engine: Engine,
        destination: Position
    ) {
        // Arrange
        val racingCar = Car(start, engine)

        // Act
        racingCar.race()
        val currentPosition = racingCar.currentPosition()

        // Assert
        assertThat(currentPosition).isEqualTo(destination.value)
    }

    @DisplayName("주어진 CustomEngine과 레이스 횟수가 올바른 경우 레이스 횟수 만큼 전진")
    @ParameterizedTest
    @MethodSource("valuesForNumberOfRaces")
    fun given_CustomEngineAndNumberOfRace_when_Race_then_MoveNumberOfRaceStep(
        start: Position,
        engine: Engine,
        numberOfRace: Int,
        destination: Position
    ) {
        // Arrange
        val racingCar = Car(start, engine)

        // Act
        racingCar.race(numberOfRace)
        val currentPosition = racingCar.currentPosition()

        // Assert
        assertThat(currentPosition).isEqualTo(destination.value)
    }

    companion object {
        @JvmStatic
        fun valuesForRace(): Stream<Arguments> =
            Stream.of(
                Arguments.of(Position(0), CustomEngine(4), Position(1)),
                Arguments.of(Position(100_200), CustomEngine(5), Position(100_201)),
                Arguments.of(Position(871), CustomEngine(6), Position(872)),
                Arguments.of(Position(108_186_191), CustomEngine(7), Position(108_186_192)),
                Arguments.of(Position(1_738_195_664), CustomEngine(8), Position(1_738_195_665)),
            )

        @JvmStatic
        fun valuesForNumberOfRaces(): Stream<Arguments> =
            Stream.of(
                Arguments.of(Position(0), CustomEngine(4), 10, Position(10)),
                Arguments.of(Position(100_200), CustomEngine(5), 10, Position(100_210)),
                Arguments.of(Position(871), CustomEngine(6), 50, Position(921)),
                Arguments.of(Position(108_186_191), CustomEngine(7), 100, Position(108_186_291)),
                Arguments.of(Position(1_738_195_664), CustomEngine(8), 10, Position(1_738_195_674)),
                Arguments.of(Position(0), CustomEngine(9), 1_000, Position(1_000))
            )
    }
}

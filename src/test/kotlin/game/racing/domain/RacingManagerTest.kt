package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class RacingManagerTest {

    @ParameterizedTest
    @ValueSource(strings = ["TEST1", "TEST2", "TEST3"])
    fun `인자로 받은 이름을 가진 자동차를 생성한다`(carName: String) {
        val car = CarFactory.generateCarByCarNames(carName)[0]

        assertThat(car.name).isEqualTo(carName)
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `자동차들의 위치를 이동시킨다`(carNames: String, speed: Int) {
        val cars = CarFactory.generateCarByCarNames(carNames)
        val racingManager = RacingManager(cars)
        val speedList = List(cars.size) { speed }
        racingManager.moveCars(speedList)

        assertThat(cars).allMatch {
            if (speed >= Car.MIN_MOVE_THRESHOLD) it.position == 1 else it.position == 0
        }
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("TEST,TEST1", 1), Arguments.of("TEST,TEST1", 4), Arguments.of("TEST,TEST1", 7)
            )
        }
    }
}

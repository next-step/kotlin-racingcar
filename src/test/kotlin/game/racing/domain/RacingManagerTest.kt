package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class RacingManagerTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `인자 숫자만큼 자동차를 생성한다`(numberOfCar: Int) {
        val generateCarByNumberOfCar = CarFactory.generateCarByNumberOfCar(numberOfCar)

        assertThat(generateCarByNumberOfCar.size).isEqualTo(numberOfCar)
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `자동차들의 위치를 이동시킨다`(numberOfCar: Int, speed: Int) {
        val cars = CarFactory.generateCarByNumberOfCar(numberOfCar)
        val racingManager = RacingManager(cars)
        val speedList = List(numberOfCar) { speed }
        racingManager.moveCars(speedList)

        assertThat(cars).allMatch {
            if (speed >= Car.MIN_MOVE_THRESHOLD) it.position == 1 else it.position == 0
        }
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(5, 1), Arguments.of(5, 4), Arguments.of(5, 7)
            )
        }
    }
}

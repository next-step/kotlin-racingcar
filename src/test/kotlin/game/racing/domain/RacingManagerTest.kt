package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class RacingManagerTest {
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

    @ParameterizedTest
    @ValueSource(strings = ["WIN,TEST2,TEST3", "TEST1,TEST2,WIN,TEST4", "TEST1,WIN,TEST3,TEST4,TEST5"])
    fun `우승자를 반환한다`(carNames: String) {
        val cars = CarFactory.generateCarByCarNames(carNames)
        val racingManager = RacingManager(cars)
        val speedList = cars.map { if (it.name == "WIN") Car.MIN_MOVE_THRESHOLD else Car.MIN_MOVE_THRESHOLD - 1 }
        racingManager.moveCars(speedList)

        assertThat(racingManager.getWinners()).allMatch { it.position == Car.MIN_POSITION + 1 }.allMatch { it.name == "WIN" }
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

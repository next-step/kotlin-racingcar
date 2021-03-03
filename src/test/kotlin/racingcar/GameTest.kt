package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.CarFixtures.alwaysMovingStrategy
import racingcar.CarFixtures.canNotMovingStrategy

internal class GameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `항상 움직이는 차 n대를 m회 진행 후 위치를 확인`(numberOfAttempts: Int) {
        val game = Game(GameConfiguration(100, numberOfAttempts), alwaysMovingStrategy())
        val startPosition = game.cars.stream()
            .findAny()
            .get()
            .position
        game.start()
        game.cars.map { car ->
            assertThat(car.position - startPosition).isEqualTo(numberOfAttempts)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `움직이지 않는 차 n대를 m회 진행 후 위치를 확인`(numberOfAttempts: Int) {
        val game = Game(GameConfiguration(100, numberOfAttempts), canNotMovingStrategy())
        val startPosition = game.cars.stream()
            .findAny()
            .get()
            .position
        game.start()
        game.cars.map { car ->
            assertThat(car.position - startPosition).isEqualTo(0)
        }
    }
}

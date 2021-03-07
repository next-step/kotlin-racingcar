package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.CarFixtures.canNotMovingStrategy
import racingcar.CarFixtures.createAlwaysMovingCar
import racingcar.CarFixtures.createCanNotMovingCar

internal class GameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `항상 움직이는 차 n대를 m회 진행 후 위치를 확인`(numberOfAttempts: Int) {
        val alwaysMovingCars = listOf(createAlwaysMovingCar(), createAlwaysMovingCar(), createAlwaysMovingCar())
        val game = Game(Cars(alwaysMovingCars),numberOfAttempts)
        val startPosition = alwaysMovingCars.stream()
            .findAny()
            .get()
            .position
        game.start()
        game.cars.cars.map { car ->
            assertThat(car.position - startPosition).isEqualTo(numberOfAttempts)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `움직이지 않는 차 n대를 m회 진행 후 위치를 확인`(numberOfAttempts: Int) {
        val alwaysMovingCars = listOf(createCanNotMovingCar(), createCanNotMovingCar(), createCanNotMovingCar())
        val game = Game(Cars(alwaysMovingCars),100)
        val startPosition = alwaysMovingCars.stream()
            .findAny()
            .get()
            .position
        game.start()
        game.cars.cars.map { car ->
            assertThat(car.position - startPosition).isEqualTo(0)
        }
    }
}

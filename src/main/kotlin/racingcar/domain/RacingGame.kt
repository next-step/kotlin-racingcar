package racingcar.domain

import racingcar.MoveStrategy

class RacingGame(
    private val moveStrategy: MoveStrategy,
) {
    fun run(attemptNumber: Int, carNames: List<String>): Cars {
        val cars = CarFactory.createsCars(carNames, moveStrategy)
        cars.moveCars(attemptNumber)

        return cars
    }
}

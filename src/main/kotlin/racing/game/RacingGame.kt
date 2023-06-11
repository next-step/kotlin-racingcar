package racing.game

import racing.car.Car
import racing.car.RacingCars
import racing.condition.MovingCondition
import racing.view.ResultView

class RacingGame(
    private val carCount: Int
) {

    var cars: RacingCars
        private set

    init {
        this.cars = racingGameCarInit(carCount)
    }

    fun racingGameCarInit(carCount: Int): RacingCars {
        val cars = List(carCount) { Car() }
        return RacingCars(cars)
    }

    fun executeGame(retryCount: Int, cars: RacingCars) {
        repeat(retryCount) {
            isMoving(cars)
            ResultView().showGameBoard(cars)
        }
    }

    fun isMoving(cars: RacingCars) {
        cars.racingCars.forEach {
            if (MovingCondition().canMove()) {
                it.move()
            }
        }
    }
}

package racing.game

import racing.car.Car
import racing.car.RacingCars
import racing.condition.MovingCondition
import racing.view.ResultView

class RacingGame(
    private val carName: List<String>
) {

    var cars: RacingCars
        private set

    init {
        this.cars = racingGameCarInit(carName)
    }

    fun racingGameCarInit(carName: List<String>): RacingCars {
        val cars = carName.map {
            Car(name = it, position = 0)
        }
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

    fun findWinner(cars: RacingCars) {
        val maxPosition = cars.racingCars.maxOf { it.getPosition() }
        val winner = cars.racingCars.filter { it.getPosition() == maxPosition }.map { it.getName() }
        ResultView().showWinner(winner)
    }
}

package racing.domain

import racing.view.ResultView

class RacingGame(
    carNames: List<String>
) {

    val cars: RacingCars

    init {
        this.cars = racingGameCarInit(carNames)
    }

    fun racingGameCarInit(carName: List<String>): RacingCars {
        val cars = carName.map {
            Car(name = it)
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
}

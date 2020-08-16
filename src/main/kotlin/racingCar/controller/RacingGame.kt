package racingCar.controller

import racingCar.model.Cars

object RacingGame {
    fun playGame(cars: Cars) {
        cars.moveCars()
    }
}

package racingcarWinner.domain

import racingcarWinner.util.MessageCode
import racingcarWinner.util.Util

object WinnerRacing {
    const val INIT_TRY_NUMBER = 1
    const val MIN_CAR_NUMBER = 1

    fun startRacing(cars: List<Car>, winner: Winner, tryNumber: Int): List<Car> {
        require(cars.count() > MIN_CAR_NUMBER) { MessageCode.CarNumberException.message }
        require(tryNumber >= INIT_TRY_NUMBER) { MessageCode.TryNumberException.message }

        return cars.map { car ->
            car.move(Util.getRandomNumber())
            winner.setMaxMoveStep(car.moveStep)
            car
        }
    }
}

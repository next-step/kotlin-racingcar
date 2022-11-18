package racingcarWinner.domain

import racingcarWinner.util.Util

object WinnerRacing {
    fun startRacing(cars: List<Car>): List<Car> =
        cars.map { car ->
            car.move(Util.getRandomNumber())
            car
        }
}

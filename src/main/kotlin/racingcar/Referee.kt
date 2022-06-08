package racingcar

import racingcar.car.Car

class Referee(private val cars: List<Car>, private val moveCount: Int) {
    fun getWinnersPosition(): Int {
        return cars.maxOf { it.positionBy(moveCount) }
    }

    fun getWinners(): List<Car> {
        val winnersPosition = getWinnersPosition()
        return cars.filter { it.positionBy(moveCount) == winnersPosition }
    }
}

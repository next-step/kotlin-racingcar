package racingcar.domain

import racingcar.RandomNumberUtils

class Round(var cars: List<Car>) {
    fun start() {
        cars.forEach { car -> car.move(getNumberToMove()) }
    }

    private fun getNumberToMove(): Int {
        return RandomNumberUtils.getRandomNumber()
    }
}

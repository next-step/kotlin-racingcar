package racingcar.domain.racing

import racingcar.domain.car.CarsFactory

class Racing(carsName: String) {
    private val cars = CarsFactory.create(carsName)

    fun start() = cars.startRound()

    fun getWinner() = cars.getWinner()
}

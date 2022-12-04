package study.racingcar.domain.racing

import study.racingcar.domain.car.Car

class Winner(private val cars: List<Car>) {
    fun findWinners(): List<Car> {
        return cars.filter { it.isWin(cars) }
    }
}

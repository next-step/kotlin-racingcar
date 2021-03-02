package racingcar.model

import racingcar.strategy.MoveStrategy

class RacingCarGame(private val cars: Cars, private val moveStrategy: MoveStrategy) {
    companion object {
        fun ready(carNames: List<String>, moveStrategy: MoveStrategy): RacingCarGame {
            val cars = Cars.makeCars(carNames)
            return RacingCarGame(cars, moveStrategy)
        }
    }

    fun moveOnce(): List<Car> {
        return cars.moveOnce(moveStrategy)
    }

    fun findWinners(): List<Car> {
        return getWinners()
    }

    fun getCarCount(): Int {
        return cars.getNumberOfCars()
    }

    fun getCars(): Cars {
        return cars
    }

    fun getWinners(): List<Car> {
        return cars.findWinners()
    }
}

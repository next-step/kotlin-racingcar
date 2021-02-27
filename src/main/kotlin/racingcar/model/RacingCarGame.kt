package racingcar.model

import racingcar.model.strategy.Strategy
import racingcar.view.ResultViews

class RacingCarGame(private val cars: Cars) {
    companion object {
        fun ready(carCount: Int): RacingCarGame {
            val cars = Cars.makeCars(carCount)
            return RacingCarGame(cars)
        }
    }

    fun moveOnce(strategy: Strategy): ResultViews {
        val resultViews = cars.moveOnce(strategy)
        return ResultViews(resultViews)
    }

    fun getCarCount(): Int {
        return cars.getNumberOfCars()
    }

    fun getCars(): Cars {
        return cars
    }
}

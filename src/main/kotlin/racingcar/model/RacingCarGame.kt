package racingcar.model

import racingcar.strategy.MoveStrategy
import racingcar.view.ResultViews

class RacingCarGame(private val cars: Cars) {
    companion object {
        fun ready(carCount: Int): RacingCarGame {
            val cars = Cars.makeCars(carCount)
            return RacingCarGame(cars)
        }
    }

    fun moveOnce(moveStrategy: MoveStrategy): ResultViews {
        val resultViews = cars.moveOnce(moveStrategy)
        return ResultViews(resultViews)
    }

    fun getCarCount(): Int {
        return cars.getNumberOfCars()
    }

    fun getCars(): Cars {
        return cars
    }
}

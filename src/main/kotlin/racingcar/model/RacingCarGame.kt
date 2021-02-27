package racingcar.model

import racingcar.strategy.MoveStrategy
import racingcar.view.ResultViews

class RacingCarGame(private val cars: Cars, private val moveStrategy: MoveStrategy) {
    companion object {
        fun ready(carNames: List<String>, moveStrategy: MoveStrategy): RacingCarGame {
            val cars = Cars.makeCars(carNames)
            return RacingCarGame(cars, moveStrategy)
        }
    }

    fun moveOnce(): ResultViews {
        val resultViews = cars.moveOnce(moveStrategy)
        return ResultViews(resultViews)
    }

    fun getCarCount(): Int {
        return cars.getNumberOfCars()
    }

    fun getCars(): Cars {
        return cars
    }

    fun getWinners(): List<String> {
        return cars.findWinners()
    }
}

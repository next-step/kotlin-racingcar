package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView
import racingcar.view.ResultViews

class RacingCar(private val cars: Cars) {
    companion object {
        fun ready(inputView: InputView): RacingCar {
            var cars = Cars.makeCars(inputView.carCount)
            return RacingCar(cars)
        }
    }

    fun runOnce(): ResultViews {
        val resultViews = cars.getCars()
            .asSequence()
            .map { car: Car ->
                val randomNumber = RandomNumber.getBetweenZeroAnd(10)
                val canMove = MoveStrategy.canMove(randomNumber)
                car.move(canMove)
                return@map ResultView(car.score)
            }
            .toList()

        return ResultViews(resultViews)
    }
}

package racingcar.model

import racingcar.utils.RandomNumber
import racingcar.view.InputView
import racingcar.view.ResultView
import racingcar.view.ResultViews

private const val MAX_NUMBER = 10

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
                val randomNumber = RandomNumber.getBetweenZeroAnd(MAX_NUMBER)
                val canMove = MoveStrategy.canMove(randomNumber)
                car.move(canMove)
                return@map ResultView(car.score)
            }
            .toList()

        return ResultViews(resultViews)
    }
}

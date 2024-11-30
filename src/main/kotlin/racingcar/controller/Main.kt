package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.ResultView
import kotlin.random.Random

fun main() {
    val names = InputView.insertCarNames()
    val movingCount = InputView.insertRunCount()
    val cars = Cars(names, movingCount) { Random.nextInt(0, 10) }
    ResultView.printResult(cars.cars, movingCount)
    ResultView.printWinner(cars.findWinner())
}

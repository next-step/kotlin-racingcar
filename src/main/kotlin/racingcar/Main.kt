package racingcar

import racingcar.util.Message.*
import racingcar.domain.CarStadium
import racingcar.view.ResultView
import racingcar.view.View

fun main(args: Array<String>) {
    val numberOfCars = View.printAndGetLineToInt(NUMBER_OF_CARS_INPUT, INPUT_EXCEPTION)
    val numberOfTrials = View.printAndGetLineToInt(NUMBER_OF_TRIALS_INPUT, INPUT_EXCEPTION)
    val result = CarStadium(numberOfCars, numberOfTrials).gameStart()
    ResultView.print(result)
}

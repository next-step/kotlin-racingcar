package racingcar

import racingcar.domain.CarMove
import racingcar.util.Message.*
import racingcar.domain.CarStadium
import racingcar.domain.IntRandomGenerator
import racingcar.view.ResultView
import racingcar.view.View

fun main(args: Array<String>) {
    val numberOfCars = View.printAndGetLineToInt(NUMBER_OF_CARS_INPUT, INPUT_EXCEPTION)
    val numberOfTrials = View.printAndGetLineToInt(NUMBER_OF_TRIALS_INPUT, INPUT_EXCEPTION)
    val result = CarStadium(
        numberOfCars,
        numberOfTrials,
        IntRandomGenerator(CarMove.CAR_RACING_RANDOM_START, CarMove.CAR_RACING_RANDOM_END)
    ).gameStart()
    ResultView.print(result)
}

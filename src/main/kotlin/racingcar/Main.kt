package racingcar

import racingcar.domain.CarMove
import racingcar.util.Message.*
import racingcar.domain.CarStadium
import racingcar.domain.RandomGenerator
import racingcar.view.ResultView
import racingcar.view.View

fun main() {
    val nameOfCars = View.printAndGetLine(NAME_OF_CARS_INPUT, INPUT_EXCEPTION)
    val numberOfTrials = View.printAndGetLineToInt(NUMBER_OF_TRIALS_INPUT, INPUT_NUMBER_EXCEPTION)
    val intRandomGenerator = RandomGenerator<Int> { start , end -> IntRange(start, end).random() }
    val result = CarStadium(
        nameOfCars,
        numberOfTrials,
        CarMove(intRandomGenerator)
    ).gameStart()

    ResultView.racingResultPrint(result)
}

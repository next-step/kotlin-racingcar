package racingcar

import racingcar.domain.CarMove
import racingcar.util.Message.*
import racingcar.domain.CarStadium
import racingcar.domain.NameValidation
import racingcar.domain.NumberGenerator
import racingcar.view.ResultView
import racingcar.view.View

fun main() {
    val nameOfCars = View.printAndGetLine(NAME_OF_CARS_INPUT, INPUT_EXCEPTION).split(",")
    val numberOfTrials = View.printAndGetLineToInt(NUMBER_OF_TRIALS_INPUT, INPUT_NUMBER_EXCEPTION)
    val isNotNameLengthOver = { names: List<String> -> names.all { it.length <= NameValidation.NAME_MAX_LENGTH }}
    require(isNotNameLengthOver(nameOfCars)) {
        CAR_NAME_LENGTH_EXCEPTION.message
    }
    val intRandomGenerator = NumberGenerator<Int> { start , end -> IntRange(start, end).random() }
    val result = CarStadium(
        nameOfCars,
        numberOfTrials,
        CarMove(intRandomGenerator)
    ).gameStart()

    ResultView.racingResultPrint(result)
}

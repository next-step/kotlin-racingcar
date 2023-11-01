package racingcar

import racingcar.util.Message.*
import racingcar.domain.NameValidation
import racingcar.domain.NumberGenerator
import racingcar.domain.RacingProperty
import racingcar.domain.RacingRule
import racingcar.view.ResultView
import racingcar.view.View

object Racing{
    const val RANDOM_START = 0
    const val RANDOM_END = 9
    const val MOVE_FORWARD_CONDITION = 4
}

fun main() {
    val nameOfCars = View.printAndGetLine(NAME_OF_CARS_INPUT, INPUT_EXCEPTION)
    val numberOfTrials = View.printAndGetLineToInt(NUMBER_OF_TRIALS_INPUT, INPUT_NUMBER_EXCEPTION)
    val isNotNameLengthOver = { names: List<String> -> names.all { it.length <= NameValidation.NAME_MAX_LENGTH }}
    val intRandomGenerator = { start: Int , end: Int -> IntRange(start, end).random() }
    val property = RacingProperty(Racing.RANDOM_START, Racing.RANDOM_END, Racing.MOVE_FORWARD_CONDITION)

    val racingRule = RacingRule(intRandomGenerator, isNotNameLengthOver, property)

    val result = RacingController(nameOfCars, numberOfTrials).start(racingRule)

    ResultView.racingResultPrint(result)
}

package racingcar.view.input

import racingcar.view.input.parser.IntInputParser

data class NumberAndSteps(val numberOfCar: Int, val stepsToTry: Int)

class NumberAndStepsInputView : InputView<NumberAndSteps> {

    override fun showInputView(): NumberAndSteps {
        val numberOfCar = readNumberOfCars()
        val countToTry = readStepsToTry()

        return NumberAndSteps(numberOfCar, countToTry)
    }

    private fun readNumberOfCars() =
        ConsoleReader.read(MESSAGE_FOR_INPUT_NUMBER_OF_CARS, IntInputParser(greaterThan = 0))

    private fun readStepsToTry() = ConsoleReader.read(MESSAGE_FOR_INPUT_STEPS_TO_TRY, IntInputParser(greaterThan = 0))

    companion object {
        private const val MESSAGE_FOR_INPUT_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?"
        private const val MESSAGE_FOR_INPUT_STEPS_TO_TRY = "시도할 횟수는 몇 회인가요?"
    }
}

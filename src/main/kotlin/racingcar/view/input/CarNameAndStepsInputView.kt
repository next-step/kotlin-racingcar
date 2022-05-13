package racingcar.view.input

import racingcar.view.input.parser.CarNamesInputParser
import racingcar.view.input.parser.IntInputParser

data class CarNamesAndSteps(val carNames: List<String>, val stepsToTry: Int)

class CarNameAndStepsInputView : InputView<CarNamesAndSteps> {

    override fun showInputView(): CarNamesAndSteps {
        val carNameList = readCarNameList()
        val countToTry = readStepsToTry()

        return CarNamesAndSteps(carNameList, countToTry)
    }

    private fun readCarNameList() =
        ConsoleReader.read(
            MESSAGE_FOR_INPUT_NAMES_OF_CAR,
            CarNamesInputParser(maxLengthOfName = MAX_LENGTH_OF_CAR_NAME)
        )

    private fun readStepsToTry() = ConsoleReader.read(MESSAGE_FOR_INPUT_STEPS_TO_TRY, IntInputParser(greaterThan = 0))

    companion object {
        private const val MAX_LENGTH_OF_CAR_NAME = 5
        private const val MESSAGE_FOR_INPUT_NAMES_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val MESSAGE_FOR_INPUT_STEPS_TO_TRY = "시도할 횟수는 몇 회인가요?"
    }
}

package racingcar

import racingcar.ExceptionType.INPUT_MUST_NOT_NULL
import racingcar.ExceptionType.TRY_INPUT_MUST_UNSIGNED_INT
import racingcar.ValidationChecker.isUnsignedInt

object InputView {

    fun readInputForCarsNameList(): List<String> {
        ResultView.printAskHowManyCars()
        val inputForCarNames = readLine()
        requireNotNull(inputForCarNames) { INPUT_MUST_NOT_NULL }
        return inputForCarNames.split(",")
    }

    fun readInputForNumberOfTry(): Int {
        ResultView.printAskHowManyTry()
        val tryInput = readLine()
        requireNotNull(tryInput) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(tryInput)) { TRY_INPUT_MUST_UNSIGNED_INT }
        return tryInput.toInt()
    }
}

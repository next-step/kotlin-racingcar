package racingcar.view

import racingcar.domain.ExceptionType.INPUT_MUST_NOT_NULL
import racingcar.domain.ExceptionType.TRY_INPUT_MUST_UNSIGNED_INT
import racingcar.domain.ValidationChecker.isUnsignedInt

object InputView {

    fun readInputForCarsNameList(): List<String> {
        val inputForCarNames = readLine()
        requireNotNull(inputForCarNames) { INPUT_MUST_NOT_NULL }
        return inputForCarNames.split(",")
    }

    fun readInputForNumberOfTry(): Int {
        val tryInput = readLine()
        requireNotNull(tryInput) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(tryInput)) { TRY_INPUT_MUST_UNSIGNED_INT }
        return tryInput.toInt()
    }
}

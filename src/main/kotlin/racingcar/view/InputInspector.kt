package racingcar.view

import racingcar.view.InputView.RE_ENTER_CAR_NAMES
import racingcar.view.InputView.RE_ENTER_NAMES_WITHIN_FIVE_LEN
import racingcar.view.InputView.RE_ENTER_RUN_COUNT
import racingcar.view.InputView.readRunCnt
import racingcar.view.InputView.splitIntoNames

object InputInspector {
    private const val MIN_COUNT_OF_CAR_NAMES = 2
    private const val MIN_COUNT_OF_RUN = 1
    private const val MAX_LENGTH_OF_CAR_NAME = 5

    var validNames = listOf<String>()

    fun validateNames(names: List<String>): List<String> {
        validNames = validateNameCnt(names) // need more than two names of cars
        validNames = validateNameLength(validNames) // check whether the length of each car fits length condition

        return validNames.map { it.trim() }
    }

    private fun validateNameCnt(carNames: List<String>): List<String> {
        var names = carNames
        while (isLessThanTwo(names)) {
            RE_ENTER_CAR_NAMES.also(::println)
            names = splitIntoNames(readLine())
        }
        return names
    }

    private fun validateNameLength(carNames: List<String>): List<String> {
        var names = carNames
        names.forEach { name ->
            if (isOverMaxLength(name.trim())) {
                RE_ENTER_NAMES_WITHIN_FIVE_LEN.also(::println)
                return validateNames(splitIntoNames(readLine()))
            }
        }
        return names
    }

    private fun isOverMaxLength(name: String) = name.length > MAX_LENGTH_OF_CAR_NAME

    private fun isLessThanTwo(names: List<String>) = names.size < MIN_COUNT_OF_CAR_NAMES

    fun validateRunCnt(RunCnt: Int?): Int {
        var runCnt = RunCnt
        while (runCnt == null || runCnt < MIN_COUNT_OF_RUN) {
            RE_ENTER_RUN_COUNT.also(::println)
            runCnt = readRunCnt()
        }
        return runCnt
    }
}

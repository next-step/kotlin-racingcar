package racingcar

import racingcar.InputView.ENTER_CAR_NAMES_AGAIN
import racingcar.InputView.ENTER_RUN_COUNT_AGAIN
import racingcar.InputView.readCarNames
import racingcar.InputView.readRunCnt

object InputInspector {
    private const val MIN_COUNT_OF_CAR_NAMES = 2
    private const val MIN_LENGTH_OF_CAR_NAME = 1
    private const val MAX_LENGTH_OF_CAR_NAME = 5

    var validNames = listOf<String>()

    fun validate(names: List<String>) {
        var names = names

        validateNumberOfCar(names) // need more than two names of cars
        validateLengthOfEachName(names) // check whether the length of each car fits length condition

        validNames = names.map { it.trim() }
    }

    private fun validateNumberOfCar(carNames: List<String>): List<String> {
        var names = carNames
        while (isLessThanTwo(names)) {
            println(ENTER_CAR_NAMES_AGAIN)
            names = readCarNames(readLine())
        }
        return names
    }

    private fun validateLengthOfEachName(carNames: List<String>) {
        var names = carNames
        names.forEach { name ->
            names = validateMinLengthOfName(name, names)
            names = validateMaxLengthOfName(name, names)
        }
    }

    private fun validateMaxLengthOfName(name: String, carNames: List<String>): List<String> {
        var names = carNames
        while (isMoreThanMaxLength(name)) {
            println(ENTER_CAR_NAMES_AGAIN)
            names = readCarNames(readLine())
        }
        return names
    }

    private fun validateMinLengthOfName(name: String, carNames: List<String>): List<String> {
        var names = carNames
        while (isLessThanMinLength(name)) {
            println(ENTER_CAR_NAMES_AGAIN)
            names = readCarNames(readLine())
        }
        return names
    }

    private fun isMoreThanMaxLength(name: String) = name.length > MAX_LENGTH_OF_CAR_NAME

    private fun isLessThanMinLength(name: String) = name.length < MIN_LENGTH_OF_CAR_NAME

    private fun isLessThanTwo(names: List<String>) = names.size < MIN_COUNT_OF_CAR_NAMES

    fun validateRunCnt(RunCnt: Int?): Int {
        var runCnt = RunCnt
        while (runCnt == null) {
            println(ENTER_RUN_COUNT_AGAIN)
            runCnt = readRunCnt()
        }
        return runCnt
    }
}

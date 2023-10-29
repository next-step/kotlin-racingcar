package racingcar.ui

private const val INPUT_RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val INPUT_COUNT_OF_RACING_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val RACING_CAR_NAME_DELIMITER = ","
private const val RACING_CAR_NAME_LENGTH_LIMIT = 5

object InputView {
    fun inputNames(): List<String> {
        println(INPUT_RACING_CAR_NAME_MESSAGE)
        val inputNames = readln().split(RACING_CAR_NAME_DELIMITER)
        return validateNames(inputNames)
    }

    private fun validateNames(inputNames: List<String>): List<String> {
        val limitOverNames = inputNames.filter { inputName -> inputName.length > RACING_CAR_NAME_LENGTH_LIMIT }
        val blankNames = inputNames.filter { inputName -> inputName.isBlank() }

        if (limitOverNames.isNotEmpty()) {
            println(limitOverNames.joinToString(RACING_CAR_NAME_DELIMITER) + " : 자동차 이름은 " + RACING_CAR_NAME_LENGTH_LIMIT + "글자를 초과하여 입력할 수 없습니다.")
            return inputNames()
        }
        if (blankNames.isNotEmpty()) {
            println("자동차 이름은 공백을 입력할 수 없습니다.")
            return inputNames()
        }
        return inputNames
    }

    fun inputCount(): Int {
        println(INPUT_COUNT_OF_RACING_MESSAGE)
        return readln().toInt()
    }
}

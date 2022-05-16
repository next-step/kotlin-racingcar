package racingcar.view

import racingcar.domain.model.GameProperties

class InputView {
    fun readGameProperties(): GameProperties {
        return GameProperties(readNamesOfCars(), readNumberOfTrials())
    }

    private fun readNamesOfCars(): List<String> {
        println(NAMES_OF_CARS_QUESTION)
        return readNextListOfStrings(NAMES_OF_CARS_SEPARATOR)
    }

    private fun readNumberOfTrials(): Int {
        println(NUM_OF_TRIALS_QUESTION)
        return readNextPositiveInteger()
    }

    private fun readNextListOfStrings(separator: String): List<String> {
        val userInput = readUserInput()

        return if (userInput.isNullOrBlank()) throw IllegalArgumentException("입력값이 주어지지 않았습니다.")
        else userInput.split(separator).map { it.trim() }
    }

    private fun readNextPositiveInteger(): Int {
        return readUserInput()
            ?.let { nullIfNonNumber(it) }
            ?.let { nullIfNegativeNumber(it) }
            ?: throw IllegalArgumentException("입력 값은 0 보다 큰 숫자이여야 합니다.")
    }

    private fun readUserInput() = readLine()

    private fun nullIfNonNumber(input: String): Int? = input.toIntOrNull()

    private fun nullIfNegativeNumber(input: Int): Int? = input.takeIf { it > 0 }

    companion object {
        private const val NUM_OF_TRIALS_QUESTION = "시도할 횟수는 몇 회인가요?"
        private const val NAMES_OF_CARS_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."

        private const val NAMES_OF_CARS_SEPARATOR = ","
    }
}

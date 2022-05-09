package racingcar.view

import racingcar.model.GameProperties

class InputView {
    fun readGameProperties(): GameProperties {
        return GameProperties(readNumberOfCars(), readNumberOfTrials())
    }

    private fun readNumberOfCars(): Int {
        println(NUM_OF_CARS_QUESTION)
        return readNextPositiveInteger()
    }

    private fun readNumberOfTrials(): Int {
        println(NUM_OF_TRIALS_QUESTION)
        return readNextPositiveInteger()
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
        private const val NUM_OF_CARS_QUESTION = "자동차 대수는 몇 대인가요?"
        private const val NUM_OF_TRIALS_QUESTION = "시도할 횟수는 몇 회인가요?"
    }
}

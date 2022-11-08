package racingcar.io

import racingcar.const.CarException
import racingcar.extension.isNumeric

object InputView {
    private const val READ_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val WRITE_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun read(): Pair<Int, Int> {
        val numberOfCars = getInput(READ_MESSAGE)
        val numberOfTry = getInput(WRITE_MESSAGE)

        return Pair(numberOfCars, numberOfTry)
    }

    private fun getInput(message: String): Int {
        println(message)
        val input = Reader.read()
        validateInput(input)
        return input!!.toInt()
    }

    private fun validateInput(input: String?) {
        require(input != null) { CarException.NULL_INPUT_ERROR }
        require(input.isNumeric()) { CarException.NOT_DIGIT_ERROR }
        require(input.toInt() > 0) { CarException.MORE_THAN_ONE }
    }
}

package racingcar.io

import racingcar.util.InputValidator
import racingcar.util.Parser

object InputView {
    private const val READ_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val WRITE_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun read(): Input {
        val carNames = getCarNames()
        val numberOfTry = getNumberOfTry()

        return Input(carNames, numberOfTry)
    }

    private fun getCarNames(): List<String> {
        println(READ_MESSAGE)
        val carNameStr = Reader.read()
        val carNames = Parser.parse(carNameStr)
        carNames.forEach { carName ->
            InputValidator.validateCarNameStr(carName)
        }
        return carNames
    }

    private fun getNumberOfTry(): Int {
        println(WRITE_MESSAGE)
        val numberOfTryStr = Reader.read()
        InputValidator.validateNumberOfTryStr(numberOfTryStr)
        return numberOfTryStr!!.toInt()
    }
}

data class Input(
    val carNames: List<String>,
    val numberOfTry: Int,
)

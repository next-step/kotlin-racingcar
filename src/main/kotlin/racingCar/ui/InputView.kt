package racingCar.ui

import racingCar.domain.CarName
import racingCar.domain.CarNames
import racingCar.domain.TryCount

object InputView {

    private const val DELIMITER = ","
    private const val CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun readCarNames(): CarNames {
        println(CAR_NAME_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        val inputCarNames = splitCarNames(userInput!!)
        val carNames = inputCarNames.map {
            CarName(it.trim())
        }
        return CarNames(carNames)
    }

    fun readTryCount(): TryCount {
        println(TRY_COUNT_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        validateNumeric(userInput!!)
        return TryCount(userInput.toInt())
    }

    private fun validateIsNullOrBlank(userInput: String?) {
        require(!userInput.isNullOrBlank()) {
            "입력값이 존재하지 않습니다."
        }
    }

    private fun splitCarNames(userInput: String): List<String> {
        return userInput.split(DELIMITER).toList()
    }

    private fun validateNumeric(userInput: String) {
        require(userInput.toIntOrNull() != null) {
            "입력값이 숫자가 아닙니다."
        }
    }
}

package racingCar.ui

import racingCar.domain.CarCount
import racingCar.domain.TryCount

object InputView {

    private const val CAR_COUNT_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun readCarCount(): CarCount {
        println(CAR_COUNT_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        validateNumeric(userInput!!)
        return CarCount(userInput.toInt())
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

    private fun validateNumeric(userInput: String) {
        require(userInput.toIntOrNull() != null) {
            "입력값이 숫자가 아닙니다."
        }
    }
}

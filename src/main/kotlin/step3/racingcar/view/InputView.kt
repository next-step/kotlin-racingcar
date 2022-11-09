package step3.racingcar.view

import step3.racingcar.expansion.isNotDigit

class InputView {
    companion object {
        private const val INVALID_INPUT_ERROR_MESSAGE = "잘못 입력하셨습니다. [%s], 숫자만 입력하세요"
        private const val CAR_COUNT_INPUT_GUIDE_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val ROUND_COUNT_INPUT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?"

        fun inputCarCountGuideMessagePrinter(): Int {
            return inputInt(CAR_COUNT_INPUT_GUIDE_MESSAGE)
        }

        fun inputRoundCountGuideMessagePrinter(): Int {
            return inputInt(ROUND_COUNT_INPUT_GUIDE_MESSAGE)
        }

        private fun inputInt(message: String): Int {
            var input: String
            do {
                println(message)
                input = readLine()!!
            } while (isNotValidInput(input))
            return input.toInt()
        }

        private fun isNotValidInput(inputValue: String): Boolean {
            if (inputValue.isNotDigit()) {
                println(INVALID_INPUT_ERROR_MESSAGE.format(inputValue))
                return true
            }
            return false
        }
    }
}

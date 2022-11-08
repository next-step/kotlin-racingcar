package step3.racingcar.view

class InputView {
    companion object {
        private const val INVALID_INPUT_ERROR_MESSAGE = "숫자만 입력하세요"

        fun inputCarCountGuideMessagePrinter(): Int {
            println("자동차 대수는 몇 대인가요?")
            return validateCount(readLine())
        }

        fun inputRoundCountGuideMessagePrinter(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return validateCount(readLine())
        }

        private fun validateCount(inputValue: String?): Int {
            require(!inputValue.isNullOrEmpty()) { INVALID_INPUT_ERROR_MESSAGE }
            return requireNotNull(inputValue.toIntOrNull()) { INVALID_INPUT_ERROR_MESSAGE }
        }
    }
}

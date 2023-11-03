package racing.v1

class InputView {
    companion object {
        private val CAR_COUNT_ERROR_MESSAGE = "자동차 대수는 숫자로 입력해주세요."
        private val TRY_COUNT_ERROR_MESSAGE = "시도할 횟수는 숫자로 입력해주세요."

        fun getInput(): Pair<String?, String?> {
            println("자동차 대수는 몇 대인가요?")
            val carCountStr: String? = readLine()
            println("시도할 횟수는 몇 회인가요?")
            val tryCountStr: String? = readLine()

            return Pair(carCountStr, tryCountStr)
        }

        fun validateInput(carCountStr: String?, tryCountStr: String?): Pair<Int, Int> {
            val carCount: Int = carCountStr?.toIntOrNull() ?: throw IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE)
            val tryCount: Int = tryCountStr?.toIntOrNull() ?: throw IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE)
            return Pair(carCount, tryCount)
        }
    }
}

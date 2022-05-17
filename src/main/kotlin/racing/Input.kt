package racing


object Input {
    private const val CAR_COUNT_MSG = "자동차 대수는 몇 대인가요?"
    private const val TRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?"
    private const val NULL_OR_EMPTY_MSG = "반드시 값을 입력해주세요."
    private const val NOT_NUMBER_MSG = "숫자값만 입력해주세요."

    private fun ask(msg: String): Int {
        println(msg)

        val input: String? = readLine()

        requireNotNull(input) { NULL_OR_EMPTY_MSG }

        return kotlin.runCatching { input.toInt() }.getOrElse {
            throw IllegalArgumentException(NOT_NUMBER_MSG)
        }
    }

    fun carCount(): Int = ask(CAR_COUNT_MSG)

    fun playCount(): Int = ask(TRY_COUNT_MSG)

}

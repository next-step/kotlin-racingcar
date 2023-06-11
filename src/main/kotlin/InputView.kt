object InputView {

    private const val DEFAULT_INPUT = 0
    private const val MINIMUM_INPUT = 1

    private const val INPUT_CAR_PREFIX = "자동차 대수는 "
    private const val INPUT_ACTION_PREFIX = "시도할 횟수는 "

    fun doInput(): Pair<Int, Int> {

        println("$INPUT_CAR_PREFIX 몇 대인가요?")
        val carNumber = getInputNumber(INPUT_CAR_PREFIX)
        println("$INPUT_ACTION_PREFIX 몇 회인가요?")
        val actionCount = getInputNumber(INPUT_ACTION_PREFIX)

        return Pair(carNumber, actionCount)
    }

    private fun getInputNumber(prefix: String): Int {
        return runCatching {
            (readlnOrNull()?.toInt() ?: DEFAULT_INPUT).apply {
                if (this < MINIMUM_INPUT) {
                    throw IllegalArgumentException("$prefix ${MINIMUM_INPUT}대 이상이어야 함")
                }
            }
        }.getOrElse {
            throw NumberFormatException("숫자 입력해야함")
        }
    }
}

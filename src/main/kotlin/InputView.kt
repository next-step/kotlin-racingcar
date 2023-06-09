object InputView {

    const val DEFAULT_INPUT = 0
    const val MINIMUM_INPUT = 1

    fun doInput(): Pair<Int, Int> {
        var carNumber = 0
        var actionCount = 0
        println("자동차 대수는 몇 대인가요?")
        runCatching {
            carNumber = readlnOrNull()?.toInt() ?: DEFAULT_INPUT
        }.getOrElse {
            throw NumberFormatException("숫자 입력해야함")
        }
        if (carNumber < MINIMUM_INPUT) {
            throw IllegalArgumentException("자동차 대수는 ${MINIMUM_INPUT}대 이상이어야 함")
        }
        println("시도할 횟수는 몇 회인가요?")
        runCatching {
            actionCount = readlnOrNull()?.toInt() ?: DEFAULT_INPUT
        }.getOrElse {
            throw NumberFormatException("숫자 입력해야함")
        }
        if (actionCount < MINIMUM_INPUT) {
            throw IllegalArgumentException("시도할 횟수는 ${MINIMUM_INPUT}회 이상이어야 함")
        }
        return Pair(carNumber, actionCount)
    }
}

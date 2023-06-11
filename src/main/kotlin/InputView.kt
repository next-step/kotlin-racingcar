object InputView {

    private const val DEFAULT_INPUT = 0
    private const val MINIMUM_INPUT = 1

    private const val INPUT_SEPERATOR = ","

    private const val INPUT_ACTION_PREFIX = "시도할 횟수는 "

    fun doInput(): Pair<List<String>, Int> {

        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNumber = getInputCars()
        println("$INPUT_ACTION_PREFIX 몇 회인가요?")
        val actionCount = getInputNumber(INPUT_ACTION_PREFIX)

        return Pair(carNumber, actionCount)
    }

    private fun getInputCars(): List<String> {
        return runCatching {
            (readlnOrNull()?:"").split(INPUT_SEPERATOR)
        }.getOrElse {
            throw IllegalArgumentException("형식에 맞는 타입을 입력해야함")
        }
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

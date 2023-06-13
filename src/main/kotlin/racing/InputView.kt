package racing

object InputView {

    private const val DEFAULT_INPUT = 0
    private const val MINIMUM_INPUT = 1

    private const val INPUT_SEPERATOR = ","

    private const val INPUT_ACTION_PREFIX = "시도할 횟수는 "

    fun doInput(): Pair<List<String>, Int> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = getInputCars()

        println("$INPUT_ACTION_PREFIX 몇 회인가요?")
        val actionCount = getInputNumber()
        if (actionCount < MINIMUM_INPUT) {
            throw IllegalArgumentException("$INPUT_ACTION_PREFIX ${MINIMUM_INPUT}대 이상이어야 함")
        }
        return Pair(carNames, actionCount)
    }

    private fun getInputCars(): List<String> {
        return runCatching {
            val inputCars = (readlnOrNull() ?: "")
            if (inputCars.isEmpty()) throw IllegalArgumentException("이름은 한글자 이상이어야 함")
            inputCars.split(INPUT_SEPERATOR)
        }.getOrElse {
            throw IllegalArgumentException("형식에 맞는 타입을 입력해야함")
        }
    }

    private fun getInputNumber(): Int {
        return runCatching {
            (readlnOrNull()?.toInt() ?: DEFAULT_INPUT)
        }.getOrElse {
            throw NumberFormatException("숫자 입력해야함")
        }
    }
}

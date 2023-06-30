package racingcar.io

object InputView {
    private const val CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val SEPARATOR = ","
    private const val INPUT_ERROR_MESSAGE = "입력이 올바르지 않습니다"

    fun getCarNames(): List<String> {
        println(CAR_NAME_INPUT_MESSAGE)
        return requireNotNull(readlnOrNull()?.run { split(SEPARATOR) }) { INPUT_ERROR_MESSAGE }
    }

    fun getRoundCount(): Int {
        println(ROUND_COUNT_INPUT_MESSAGE)
        return requireNotNull(readlnOrNull()?.run { toInt() }) { INPUT_ERROR_MESSAGE }
    }
}

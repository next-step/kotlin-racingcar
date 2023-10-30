package racingcar.view

object InputView {
    private const val CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val TRY_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val NO_ALLOW_EMPTY_VALUE_MESSAGE = "빈 값은 허용되지 않습니다."

    fun getNamesOfCars(): List<String> {
        println(CAR_INPUT_MESSAGE)
        val input = readlnOrNull()
        check(!input.isNullOrBlank()) { NO_ALLOW_EMPTY_VALUE_MESSAGE }
        return input.split(",")
    }

    fun getNumbersOfTry(): Int {
        println(TRY_INPUT_MESSAGE)
        val input = readlnOrNull()
        check(!input.isNullOrBlank()) { NO_ALLOW_EMPTY_VALUE_MESSAGE }
        return input.toInt()
    }
}

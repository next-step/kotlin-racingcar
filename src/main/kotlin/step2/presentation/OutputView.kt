package step2.presentation

object OutputView {

    private const val START_CALCULATOR_MESSAGE = "연산하고자 하는 문자열을 입력해 주세요. (ex. 2 + 3 * 4 / 2) : "
    private const val RESULT_CALCULATOR_MESSAGE = "입력한 연산 문자열을 연산한 결과 : "

    fun printStartCalculator() = print(message = START_CALCULATOR_MESSAGE)

    fun printResultCalculator(result: String) = println(message = "$RESULT_CALCULATOR_MESSAGE$result")
}

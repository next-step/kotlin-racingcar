package racingcar.view

object InputView {
    private const val INPUT_CAR_COUNT = "자동차 대수는 몇 대인가요?"
    private const val ERR_INVALID_NUM = "1 이상의 정수를 입력해주세요."
    private const val INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?"

    fun readCarCount(isValid: (value: Int) -> Boolean) = readNumber(isValid, INPUT_CAR_COUNT)

    fun readTryCount(isValid: (value: Int) -> Boolean) = readNumber(isValid, INPUT_TRY_COUNT)

    private fun readNumber() = readLine()?.trim()?.toIntOrNull()

    private fun readNumber(
        inputCondition: (value: Int) -> Boolean,
        titleMsg: String,
        errMsg: String = ERR_INVALID_NUM
    ): Int {
        println(titleMsg)
        var number = readNumber()

        while (number == null || !inputCondition(number)) {
            println(errMsg)
            number = readNumber()
        }

        return number
    }
}

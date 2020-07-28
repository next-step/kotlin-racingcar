package racingcar.view

object InputView {
    private const val INPUT_PARTICIPANTS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ERR_INVALID_NAMES = "하나 이상의 이름을 입력해주세요."
    private const val ERR_INVALID_NUM = "1 이상의 정수를 입력해주세요."
    private const val INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?"

    fun readCarNames() = readValue({ true }, INPUT_PARTICIPANTS, ERR_INVALID_NAMES)

    fun readTryCount(isValid: (value: String) -> Boolean) = readValue(isValid, INPUT_TRY_COUNT, ERR_INVALID_NUM).toInt()

    private fun readValue(
        isValid: (value: String) -> Boolean,
        titleMsg: String,
        errMsg: String
    ): String {
        println(titleMsg)
        var string = readLine()

        while (string.isNullOrBlank() || !isValid(string)) {
            println(errMsg)
            string = readLine()
        }

        return string
    }
}

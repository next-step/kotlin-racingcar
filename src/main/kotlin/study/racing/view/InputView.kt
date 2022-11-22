package study.racing.view

sealed class InputView(
    val promptMessage: String,
    val errorMessage: String,
) {
    protected fun getValue(): String? {
        println(promptMessage)
        return readLine()
    }

    object CarName : InputView(
        promptMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
        errorMessage = "올바르지 않은 자동차 이름 값이 입력되었습니다.",
    ) {
        fun getNames(): List<String> = getValue()
            ?.split(SEPARATOR)
            ?.takeIf { it.isNotEmpty() }
            ?: throw IllegalArgumentException(errorMessage)

        private const val SEPARATOR = ","
    }

    object RoundCount : InputView(
        promptMessage = "시도할 횟수는 몇 회인가요?",
        errorMessage = "올바르지 않은 시도 횟수 값이 입력되었습니다.",
    ) {
        fun getCount(): Int = getValue()
            ?.toIntOrNull()
            ?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(errorMessage)
    }
}
package study.racing.ui

import study.racing.ValueProvider

sealed class InputView(
    val promptMessage: String,
    val errorMessage: String,
    protected open val valueProvider: ValueProvider<String?>,
) {
    protected fun getValue(): String? {
        println(promptMessage)
        return valueProvider.getValue()
    }

    data class CarName(
        override val valueProvider: ValueProvider<String?>,
    ) : InputView(
        promptMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
        errorMessage = "올바르지 않은 자동차 이름 값이 입력되었습니다.",
        valueProvider = valueProvider,
    ) {
        fun getNames(): List<String> = getValue()
            ?.split(",")
            ?.takeIf { it.isNotEmpty() }
            ?: throw IllegalArgumentException(errorMessage)

        companion object {
            private const val SEPARATOR = ","
        }
    }

    data class RoundCount(
        override val valueProvider: ValueProvider<String?>,
    ) : InputView(
        promptMessage = "시도할 횟수는 몇 회인가요?",
        errorMessage = "올바르지 않은 시도 횟수 값이 입력되었습니다.",
        valueProvider = valueProvider,
    ) {
        fun getCount(): Int = getValue()
            ?.toIntOrNull()
            ?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(errorMessage)
    }
}
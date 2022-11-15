package study.racing.ui

import study.racing.ValueProvider

sealed class InputView(
    val promptMessage: String,
    val errorMessage: String,
    protected open val valueProvider: ValueProvider<String?>,
) {
    data class CarCount(
        override val valueProvider: ValueProvider<String?>,
    ) : InputView(
        promptMessage = "자동차 대수는 몇 대인가요?",
        errorMessage = "올바르지 않은 자동차 대수 값이 입력되었습니다.",
        valueProvider = valueProvider,
    )

    data class RoundCount(
        override val valueProvider: ValueProvider<String?>,
    ) : InputView(
        promptMessage = "시도할 횟수는 몇 회인가요?",
        errorMessage = "올바르지 않은 시도 횟수 값이 입력되었습니다.",
        valueProvider = valueProvider,
    )

    fun getCount(): Int {
        println(promptMessage)
        return valueProvider.getValue()
            ?.toIntOrNull()
            ?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(errorMessage)
    }
}
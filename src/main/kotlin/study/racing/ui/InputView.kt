package study.racing.ui

import study.racing.CountProvider

sealed class InputView(
    val promptMessage: String,
    val errorMessage: String,
    protected open val countProvider: CountProvider,
) {
    data class CarCount(
        override val countProvider: CountProvider,
    ) : InputView(
        promptMessage = "자동차 대수는 몇 대인가요?",
        errorMessage = "올바르지 않은 자동차 대수 값이 입력되었습니다.",
        countProvider = countProvider,
    )

    data class RoundCount(
        override val countProvider: CountProvider,
    ) : InputView(
        promptMessage = "시도할 횟수는 몇 회인가요?",
        errorMessage = "올바르지 않은 시도 횟수 값이 입력되었습니다.",
        countProvider = countProvider,
    )

    fun getCount(): Int {
        println(promptMessage)
        return countProvider.getCount()
            ?.toIntOrNull()
            ?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(errorMessage)
    }
}
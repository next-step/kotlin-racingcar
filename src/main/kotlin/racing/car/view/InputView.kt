package racing.car.view

object InputView {
    fun enterCarCount(): Int {
        return enterCount { println("자동차 대수는 몇 대인가요?") }
    }

    fun enterRoundCount(): Int {
        return enterCount { println("시도할 횟수는 몇 회인가요?") }
    }

    private fun enterCount(printMessage: () -> Unit = { println("숫자를 입력해주세요.") }): Int {
        printMessage()
        val input = readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_MUST_POSITIVE_NUMBER)
        require(input >= 0) { INPUT_MUST_POSITIVE_NUMBER }
        return input
    }
}

private const val INPUT_MUST_POSITIVE_NUMBER = "0 이상의 숫자를 입력해주세요."

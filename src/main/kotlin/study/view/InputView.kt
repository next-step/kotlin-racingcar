package study.view

object InputView {
    fun askCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
    }

    fun askTotalRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
    }
}

private const val INPUT_ERROR_MESSAGE = "숫자만 입력 가능합니다."

package study.racingcar.ui

object InputView {
    private const val INPUT_CAR_COUNT_COMMENT = "자동차 대수는 몇 대인가요?"
    private const val INPUT_TRY_COUNT_COMMENT = "시도할 횟수는 몇 회인가요?"

    fun inputCarCount(): Int {
        println(INPUT_CAR_COUNT_COMMENT)
        return readLine()?.toInt() ?: throw IllegalArgumentException("잘못된 입력값 입니다.")
    }

    fun inputTryCount(): Int {
        println(INPUT_TRY_COUNT_COMMENT)
        return readLine()?.toInt() ?: throw IllegalArgumentException("잘못된 입력값 입니다.")
    }
}

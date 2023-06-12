package racing.ui

object InputView {

    private const val ERROR_MESSAGE = "0 이상의 정수를 입력해주세요."

    fun read(): RacingInputDto {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readlnOrNull()?.toInt() ?: throw IllegalArgumentException(ERROR_MESSAGE)

        println("시도할 횟수는 몇 회인가요?")
        val attemptCount = readlnOrNull()?.toInt() ?: throw IllegalArgumentException(ERROR_MESSAGE)

        return RacingInputDto(carCount, attemptCount)
    }
}

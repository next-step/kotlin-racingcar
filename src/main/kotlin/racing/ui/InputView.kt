package racing.ui

object InputView {

    private const val CAR_NAME_EMPTY_ERROR_MESSAGE = "자동차 이름을 입력해주세요."
    private const val ATTEMPT_COUNT_ERROR_MESSAGE = "0 이상의 정수를 입력해주세요."
    private const val CAR_NAME_DELIMITER = ","

    fun read(): RacingInputDto {

        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readlnOrNull()?.split(CAR_NAME_DELIMITER)
            ?: throw IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE)

        println("시도할 횟수는 몇 회인가요?")
        val attemptCount = readlnOrNull()?.toInt() ?: throw IllegalArgumentException(ATTEMPT_COUNT_ERROR_MESSAGE)

        return RacingInputDto(carNames, attemptCount)
    }
}

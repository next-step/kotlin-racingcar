package racingcar.view

object InputView {
    private const val ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ASK_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?"

    fun readRacingCarNames() {
        println(ASK_CAR_NAME_MESSAGE)
    }

    fun readTryCount() {
        println(ASK_TRY_COUNT_MESSAGE)
    }
}

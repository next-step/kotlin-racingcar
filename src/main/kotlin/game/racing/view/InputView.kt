package game.racing.view

object InputView {
    private const val HOW_MANY_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val HOW_MANY_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?"

    fun inputCarNames(): String {
        println(HOW_MANY_CAR_MESSAGE)
        return readln()
    }

    fun inputTryNumber(): Int {
        println(HOW_MANY_TRY_MESSAGE)
        return readln().toInt()
    }
}

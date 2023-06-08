package step3.view

object InputView {

    private const val ENTER_CAR_COUNT: String = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ENTER_ROUND: String = "시도할 횟수는 몇 회인가요?"

    fun readStartInput(): RaceGameInput {
        println(message = ENTER_CAR_COUNT)
        val carNames = readln()

        println(message = ENTER_ROUND)
        val round = readln()

        return RaceGameInput(
            carNamesInput = carNames,
            roundInput = round,
        )
    }
}

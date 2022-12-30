package view

object InputView {
    fun executeInputScreen(): RacingGameInput {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames: String = readln()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readln().toInt()

        return RacingGameInput(carNames, tryCount)
    }
}

data class RacingGameInput(
    val carNames: String,
    val tryCount: Int
)
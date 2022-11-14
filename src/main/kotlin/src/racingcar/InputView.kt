package src.racingcar

object InputView {
    fun executeInputScreen(): RacingCarGameInput {
        println("자동차 대수는 몇 대인가요?")
        val carNumber: String = readln()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readln().toInt()

        return RacingCarGameInput(carNumber.toInt(), tryCount)
    }
}

data class RacingCarGameInput(
    val carNumber: Int,
    val tryCount: Int
)

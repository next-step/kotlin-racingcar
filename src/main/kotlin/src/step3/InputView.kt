package src.step3

object InputView {
    fun executeInputScreen(): RacingCarGameInput {
        println("자동차 대수는 몇 대인가요?")
        val carNumber: String? = readLine()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()!!.toInt()

        return RacingCarGameInput(carNumber!!, tryCount)
    }
}

data class RacingCarGameInput(
    val carNumber: String,
    val tryCount: Int
)

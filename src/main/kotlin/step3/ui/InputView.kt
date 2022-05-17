package step3.ui

object InputView {
    private const val CAR_COUNT_MSG = "자동차 대수는 몇 대인가요?"
    private const val RACE_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun getRaceInfo(): Pair<Int, Int> {
        val carCount = readNumber(CAR_COUNT_MSG)
        val raceRound = readNumber(RACE_ROUND_MESSAGE)

        return Pair(carCount, raceRound)
    }

    private fun readNumber(askMessage: String): Int {
        println(askMessage)
        return readLine()!!.toInt()
    }
}

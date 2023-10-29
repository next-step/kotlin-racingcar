package racingcar.view

object RacingCarInputView {
    fun readInput(): RacingCarInput {
        println("자동차 대수는 몇 대인가요?")
        val totalCarCount = readln().toInt()

        println("시도할 횟수는 몇 회인가요?")
        val totalRound = readln().toInt()

        return RacingCarInput(
            totalCarCount = totalCarCount,
            totalRound = totalRound,
        )
    }
}

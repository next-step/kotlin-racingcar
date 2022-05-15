package racingcar.ui

object InputView {
    fun run(): GameInput {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()!!.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val round = readLine()!!.toInt()
        println()

        return GameInput(carCount, round)
    }
}

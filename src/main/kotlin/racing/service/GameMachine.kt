package racing.service

import racing.constant.RacingGameConstant

object GameMachine {
    fun askCounting(question: String): Int {
        println(question)
        return readLine().orEmpty().toInt()
    }

    fun printResult(carCount: Int, tryGameCount: Int) {
        println(RacingGameConstant.RESULT_SENTENCE)
        repeat(tryGameCount) {
            Racing(carCount).play()

        }
    }
}

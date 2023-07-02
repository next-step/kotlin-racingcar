package racing.service

import racing.model.Racing

object GameMachine {
    private const val RESULT_SENTENCE = "실행 결과"
    fun askCounting(question: String): Int {
        println(question)
        return readln().orEmpty().toInt()
    }

    fun printResult(carCount: Int, tryGameCount: Int) {
        println(RESULT_SENTENCE)
        play(carCount, tryGameCount)
    }

    fun play(carCount: Int, tryGameCount: Int) {
        val racing = Racing(carCount, tryGameCount)
        racing.play()
    }
}

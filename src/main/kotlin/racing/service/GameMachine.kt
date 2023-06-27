package racing.service

import racing.model.Racing

object GameMachine {
    private const val CAR_SYMBOL = "-"
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
        val racing = Racing(carCount)
        repeat(tryGameCount) {
            racing.cars.forEach { car ->
                val moving = car.run()
                repeat(moving) {
                    print(CAR_SYMBOL)
                }
                println()
            }
            println()
        }
        println()
    }
}

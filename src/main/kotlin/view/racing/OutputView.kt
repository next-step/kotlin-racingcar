package view.racing

import domain.racing.Car

object OutputView {
    private const val SEPARATOR = ","

    fun printResult(results: List<Map<Car, String>>) {
        print("실행결과")

        results.forEach { result ->
            result.forEach { (key, value) ->
                val name = key.getName()
                println("$name : $value")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(SEPARATOR)
        println("$winnerNames 가 최종 우승했습니다.")
    }
}

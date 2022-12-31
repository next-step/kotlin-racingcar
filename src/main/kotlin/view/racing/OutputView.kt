package view.racing

import domain.racing.Car

class OutputView private constructor() {
    companion object {
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
            val winnerNames = winners.joinToString(",")
            println("$winnerNames 가 최종 우승했습니다.")
        }
    }
}

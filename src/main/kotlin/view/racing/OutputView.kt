package view.racing

import domain.racing.Car

class OutputView private constructor() {
    companion object {
        fun printResult(results: List<Map<Car, String>>) {
            print("실행결과")

            results.forEach { result ->
                result.values.forEach { it -> println(it) }
                println()
            }
        }
    }
}

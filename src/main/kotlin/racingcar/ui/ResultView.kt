package racingcar.ui

import racingcar.racingcar.CarRacingResult

class ResultView {
    fun view(carRacingResult: CarRacingResult) {
        val results = carRacingResult.getAll()
        results.forEachIndexed { turn, result ->
            printResult(turn, result)
        }
    }

    private fun printResult(turn: Int, result: List<String>) {
        println("${turn + 1} 회")
        println(result.joinToString("\n"))
    }
}

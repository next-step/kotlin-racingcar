package racingcar.view

import racingcar.domain.Car

class ResultView {
    fun showResult(racingResult: String, winnerResult: List<Car>) {
        println(racingResult)
        println(winnerResult.toPrintable())
    }

    private fun List<Car>.toPrintable(): String {
        return joinToString(separator = WINNER_SEPARATOR, postfix = WINNER_IS) { it.name }
    }
}

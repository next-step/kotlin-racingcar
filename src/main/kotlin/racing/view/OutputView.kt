package racing.view

import racing.domain.Car
import racing.domain.RacingResult

internal class OutputView {

    fun renderResult(racingResult: RacingResult) {
        println("\n실행 결과")

        racingResult.carsHistories.forEach {
            renderRound(it)
            println()
        }

        renderWinners(racingResult.winners)
    }

    private fun renderRound(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${POSITION_CHAR.repeat(it.position)}")
        }
    }

    private fun renderWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    companion object {
        private const val POSITION_CHAR = "-"
    }
}

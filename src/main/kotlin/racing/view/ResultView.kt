package racing.view

import racing.dto.RacingRecord
import racing.dto.TrackResult

object ResultView {
    fun display(racingRecord: RacingRecord) {
        val trackResults = racingRecord.trackResults
        trackResults.forEachIndexed { index, gameResult -> displayMoveResults(gameResult, isLastMove(index, trackResults.size)) }
    }

    private fun displayMoveResults(gameResult: TrackResult, isLastMove: Boolean) {
        gameResult.moveResults.forEach { println("${it.car.name} : " + "-".repeat(it.position)) }
        println()
        if (isLastMove) {
            displayWinner(gameResult)
        }
    }

    private fun isLastMove(index: Int, listSize: Int): Boolean {
        return (index == listSize - 1)
    }

    private fun displayWinner(trackResult: TrackResult) {
        val winners = trackResult.winnerCars.joinToString(", ") { it.name }
        println("${winners}가 최종 우승했습니다.")
    }
}
